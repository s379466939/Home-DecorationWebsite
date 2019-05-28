//package com.cc.controller;
//
//import com.cc.util.StringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/home")
//public class HomeContreller {
//
//    private final static String tag = "HomeCotroller";
//
//    @Autowired
//    UserService userService;
//
//    @RequestMapping(value = "/{currPage}", method = RequestMethod.GET)
//    public String home(@PathVariable("currPage") Integer currPage,
//                       // @RequestParam(value = "jobproperties") String jobproperties, @RequestParam(value = "workplace") String workplace,
//                       HttpServletRequest request) {
//        PageBean pageBean = new PageBean(currPage, 4);
//        pageBean.setTotalPage(userService.queryTotalCount(new Snack()));
//        List<Snack> snacks = userService.querySnackInfoBySql(currPage, pageBean.getPageSize(), new Snack());
//        Map<Integer, String[]> picUrls = new HashMap<Integer, String[]>();
//        for (Snack snack : snacks) {
//            picUrls.put(snack.getId(), snack.getPicurls().split(" "));
//        }
//
//        request.setAttribute("snacks", snacks);
//        request.setAttribute("currPage", (pageBean.getTotalPage() == 0 ? 0 : currPage));
//        request.setAttribute("totalPage", pageBean.getTotalPage());
//        request.setAttribute("picUrls", picUrls);
//        request.setAttribute("test", "testEL");
//
//        return "index";
//    }
//
//    @RequestMapping("toRegister")
//    public String register() {
//        return "register";
//    }
//
//    @RequestMapping("toLogin")
//    public String toLogin() {
//        return "login";
//    }
//
//    @RequestMapping("toUserCenter")
//    public String toUserCenter(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//
//        if (user.getRole().equals("consumer")) {
//            return "consumerCenter";
//        } else if (user.getRole().equals("merchant")) {
//            return "merchantCenter";
//        }
//        return "redirect:/home/1";
//    }
//
//    @RequestMapping("toCover")
//    public String toCover() {
//        return "cover";
//    }
//
//    @RequestMapping("toPostSnackInfo")
//    public String toPostSnackInfo() {
//        return "postSnackInfo";
//    }
//
//    @RequestMapping("viewConcreteSnackInfo")
//    public String viewConcreteSnackInfo(@RequestParam("snackId") Integer snackId, HttpServletRequest request) {
//        Snack snack = userService.querySnackById(snackId);
//        request.setAttribute("snack", snack);
//        String[] picUri = snack.getPicurls().split(" ");
//        List<String> picList = new ArrayList<String>();
//        for (int i = 0; i < picUri.length; i++) {
//            picList.add(picUri[i]);
//        }
//        System.out.println(">>>>picList.toString(): " + picList.toString());
//        request.setAttribute("picList", picList);
//        return "viewConcreteSnackInfo";
//    }
//
//    @RequestMapping("toAjaxLogin")
//    public String toAjaxLogin() {
//        return "test";
//    }
//
//
//    @RequestMapping(value = "ajaxLogin", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, String> ajaxLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
//        Map<String, String> map = new HashMap<String, String>();
//        String result = null;
//        if (username.equals("") || password.equals("")) {
//            result = "用户名或密码不能为空";
//            map.put("result", result);
//            return map;
//        }
//        List<User> users = userService.getUsers();
//        for (User user : users) {
//            if (username.equals(user.getAccount()) && password.equals(user.getPassword())) {
//                result = "登录成功！";
//                map.put("result", result);
//                return map;
//            }
//        }
//        result = "用户名或密码错误！";
//        map.put("result", result);
//        return map;
//    }
//
//
//    @RequestMapping(value = "ajaxGetSnacks/{currPage}", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> ajaxGetSnacks(@PathVariable(value = "currPage") Integer currPage,
//                                             SnackCharacterFilterPojo snackCharacterFilterPojo,
//                                             HttpServletRequest request) {
//
//        snackCharacterFilterPojo.setName(
//                StringUtil.isEmpty(snackCharacterFilterPojo.getName())
//                        ? null : snackCharacterFilterPojo.getName());
//
//        snackCharacterFilterPojo.setType(
//                StringUtil.isEmpty(snackCharacterFilterPojo.getType())
//                ? null : snackCharacterFilterPojo.getType());
//        snackCharacterFilterPojo.setManufacturer(
//                StringUtil.isEmpty(snackCharacterFilterPojo.getManufacturer())
//                ? null : snackCharacterFilterPojo.getManufacturer()
//        );
//
//        //验证snack筛选条件
//        System.out.println(tag + ">>ajaxGetSnacks()>>"
//                + "name: " + snackCharacterFilterPojo.getName()
//                + " type: " + snackCharacterFilterPojo.getType()
//                + " lowestPrice: " + snackCharacterFilterPojo.getLowestPrice()
//                + " highestPrice: " + snackCharacterFilterPojo.getHighestPrice()
//                + " manufacturer: " + snackCharacterFilterPojo.getManufacturer());
//
//        //设置页面大小
//        PageBean pageBean = new PageBean(currPage, 4);
//        pageBean.setTotalPage(userService.countSnacksByFilteredCharacter(snackCharacterFilterPojo));
////
//        Map<String, Object> data = new HashMap<String, Object>();
////
//        Map<String, Integer> pageMap = new HashMap<String, Integer>();
//        pageMap.put("currPage", pageBean.getCurrPage());
//        pageMap.put("totalPage", pageBean.getTotalPage());
////
//        List<Snack> lists = userService.selectSnacksByFilteredCharacterOnPage(snackCharacterFilterPojo, currPage, pageBean.getPageSize());
////
//        Map<Integer, String[]> picUrls = new HashMap<Integer, String[]>();
//        for (Snack snack : lists) {
//            picUrls.put(snack.getId(), snack.getPicurls().split(" "));
//        }
//        data.put("snacks", lists);
//        data.put("picUrls", picUrls);
//        data.put("pageMap", pageMap);
//
//        return data;
//    }
//}
