package com.cc.controller;

import com.cc.model.*;
import com.cc.service.UserService;
import com.cc.util.StringUtil;
import com.cc.util.Upload;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class MainController {

    private final static String tag = "com.cc.controller.MainController";

    @Autowired
    UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        System.out.println(tag + "  account: " + user.getAccount() + " password: " + user.getPassword());
        //登录成功跳转到首页
        if (userService.hasAccount(user)) {
            //将登录的用户对象User保存到会话中
            HttpSession session = request.getSession();
            session.setAttribute("user", userService.getUserByAccount(user));
            request.setAttribute("result", "登录成功！");
            return "guide";
        }
        request.setAttribute("result", "用户名或密码错误！");
        return "login";

    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/homeDecoration/home";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, HttpServletRequest request) {
        System.out.println(tag + ">>register>>  account: " + user.getAccount()
                + "  password: " + user.getPassword()
                + "  nickname:  " + user.getNickname()
                + "  role:  " + userService.getRoleById(user.getRole()).getType());
        if (userService.insertUserSelective(user)) {
            request.setAttribute("result", "注册成功，请登录！");
            return "login";
        }
        request.setAttribute("result", "用户名已存在");
        return "register";
    }

    @RequestMapping("toUserCenter")
    public String toUserCenter(@Param("userId")Integer userId, HttpServletRequest request) {
        //根据用户id获取所有合同
        List<Contract> contractList = userService.selectContractByUserId(userId);
//        Map<>
//        for()
        System.out.println(tag+":  toUserCenter:  contractList: "+contractList);
        request.setAttribute("contractList", contractList);
        return "UserCenter";
    }

    @RequestMapping(value = "UserCenter_data", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> UserCenter_data(@Param("userId") Integer userId, HttpServletRequest request) {
        Map<String, Object> listMap = new HashMap<String, Object>();
        //根据用户id获取所有预约装修订单
        System.out.println(tag + ": UserCenter_data: userId: " + userId);
        List<ReserveDecoration> reservationList = userService.getAllReservationsByUserId(userId);
        System.out.println(tag + ": UserCenter_data: reservationList: " + reservationList);

        listMap.put("reservationList", reservationList);
        return listMap;
    }

    @RequestMapping(value = "MerchantCenter_data", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> MerchantCenter_data(@Param("userId") String userId, HttpServletRequest request) {
        Map<String, Object> listMap = new HashMap<String, Object>();
        //获取所有预约订单
        List<ReserveDecoration> reservationList = userService.getAllReservations();
        System.out.println(tag + ": MerchantCenter_data: reservationList: " + reservationList);
        //获取所有的合同信息
        List<Contract> contractList = userService.getAllContract();
        System.out.println(tag + ": MerchantCenter_data: contractList: " + contractList);

        listMap.put("reservationList", reservationList);
        listMap.put("contractList", contractList);
        return listMap;
    }


    @RequestMapping("toMerchantCenter")
    public String toMerchantCenter(@Param("userId")Integer userId, HttpServletRequest request) {
        return "MerchantCenter";
    }

    @RequestMapping("toPostGalleryDesign")
    public String toPostGalleryDesign() {
        return "postGalleryDesign";
    }

    @RequestMapping("postGalleryDesign")
    public String postGalleryDesign(GalleryDesign galleryDesign, HttpServletRequest request) {
        System.out.println("galleryDesign:   " + galleryDesign.toString());
        //保存图片到本地并获取url
        String picUrl = Upload.uploadFile(request);
        System.out.println(tag + ">>>>community:  " + request.getParameter("community")
                + "    picUrl:  " + picUrl
                + "    housetype:  " + request.getParameter("housetype")
                + "    area:  " + request.getParameter("area")
                + "    cost:  " + request.getParameter("cost")
                + "    style:  " + request.getParameter("style"));
        galleryDesign.setPicurl(picUrl);
        galleryDesign.setArea(Float.parseFloat(request.getParameter("area")));
        galleryDesign.setArea(Float.parseFloat(request.getParameter("cost")));

        boolean flag = userService.insertGalleryDesign(galleryDesign);
        if (flag) {
            request.setAttribute("result", "记录添加成功！");
            return "gallery";
        }
        request.setAttribute("result", "记录添加失败，请重试！");
        return "postGalleryDesign";
    }

    @RequestMapping(value = "reserveDecoration", method = RequestMethod.POST)
    public String reserveDecoration(ReserveDecoration reserveDecoration, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        long tel = Long.parseLong(request.getParameter("tel"));
        Date date = StringUtil.StringToSQLDate(StringUtil.getCurrentUtilDate());
        System.out.println("userId: " + userId + "  tel: " + tel
                + "  realname: " + reserveDecoration.getRealname()
                + "  date: " + date);
        reserveDecoration.setUserid(userId);
        reserveDecoration.setTel(tel);
        reserveDecoration.setReservedate(date);
        boolean flag = userService.insertReserveDecoration(reserveDecoration);
        if (flag) {
            request.setAttribute("result", "预约成功！");
            return "gallery";
        }
        request.setAttribute("result", "预约失败！");
        return "gallery";
    }

    @RequestMapping("modifyReservationState")
    public String modifyReservationState(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String resState = request.getParameter("isdone");

        System.out.println(tag + ":  modifyReservationState:  id: " + id + "  resState: " + resState);
        boolean flag = userService.modifyReservationStateById("true".equals(resState), id);
        if (flag) {
            request.setAttribute("result", "预约状态修改成功！");
        } else {
            request.setAttribute("result", "预约状态修改失败！");
        }
        return "MerchantCenter";
    }

    @RequestMapping("createContract")
    public String createContract() {
        return "createContract";
    }

    @RequestMapping(value = "postContract", method = RequestMethod.POST)
    public String postContract(Contract contract, HttpServletRequest request) {
        String userId = request.getParameter("userid");
        System.out.println(tag + ":  postContract:  userid: " + userId
                + "  username: " + contract.getUsername()
                + "  merchant: " + contract.getMerchant()
                + "  contractcontent: " + contract.getContractcontent()
                + "  houselocation: " + contract.getHouselocation()
                + "  housedescription: " + contract.getHousedescription()
                + "  constructiontime: " + contract.getConstructiontime());
        contract.setUserid(Integer.parseInt(userId));
        boolean flag = userService.insertContractSelective(contract);
        if (flag) {
            request.setAttribute("result", "合同创建成功！");
            return "MerchantCenter";
        }
        request.setAttribute("result", "合同创建失败");
        return "MerchantCenter";
    }

    @RequestMapping("modifyContractState")
    public String modifyContractState(HttpServletRequest request) {
        String conState = request.getParameter("contractState");
        String id = request.getParameter("id");
        System.out.println(tag + ":  modifyContractState:  " + "  contractState: " + conState + "  id: " + id);
        boolean flag = userService.modifyContractStateById("true".equals(conState), Integer.parseInt(id));
        if (flag) {
            request.setAttribute("result", "合同状态修改成功！");
        } else {
            request.setAttribute("result", "合同状态修改失败");
        }
        return "MerchantCenter";
    }

    @RequestMapping("toPostDecorationProcess")
    public String toPostDecorationProcess(@Param("contract_id") Integer contract_id, HttpServletRequest request) {
        System.out.println(tag + "  toPostDecorationProcess:  contract_id: " + contract_id);
        request.setAttribute("contract_id", contract_id);
        return "postDecorationProcess";
    }


    @RequestMapping("postDecorationProcess")
    public String postConstructionProcess(@Param("contract_id")Integer contract_id,
                                          DecorationProcess decorationProcess, HttpServletRequest request) {
       String picUrls  =  Upload.uploadFile(request);
        System.out.println(tag + ":  postConstructionProcess:  contract_id: " + contract_id
                + "  getConstructionTime: " + decorationProcess.getConstructionTime()
                + "  getConstructionContent: " + decorationProcess.getConstructionContent()
                + "  picUrls: " + picUrls
                + "  getRemarks: " + decorationProcess.getRemarks());
        decorationProcess.setContract_id(contract_id);
        decorationProcess.setConstructionPicUrls(picUrls);
        boolean flag = userService.insertDecorationProcess(decorationProcess);
        if (flag) {
            request.setAttribute("result", "发布装修进度信息成功！");
        }else{
            request.setAttribute("result", "发布装修进度信息失败！");
        }
        return "MerchantCenter";
    }

    @RequestMapping("viewDecorationProgress")
    public String viewDecorationProgress(@Param("contract_id") Integer contract_id, HttpServletRequest request) {
        System.out.println(tag + ":  viewDecorationProgress:  contract_id: " + contract_id);
        List<DecorationProcess> decorationProgressList = userService.selectDecorationProcessByContractId(contract_id);
        //见图片url字符串解析并单独存放到Map<Integer, String[]>中
        Map<Integer, String[]> picUrlsMap = new HashMap<Integer, String[]>();
        for (DecorationProcess decorationProcess : decorationProgressList) {
            picUrlsMap.put(decorationProcess.getId(), decorationProcess.getConstructionPicUrls().split(" "));
        }
        request.setAttribute("decorationProgressList", decorationProgressList);
        request.setAttribute("picUrlsMap", picUrlsMap);
        return "viewDecorationProgress";
    }
}
