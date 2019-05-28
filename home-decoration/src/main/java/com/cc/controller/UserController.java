//package com.cc.controller;
//
//import com.cc.util.StringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.File;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//
//@Controller
//@RequestMapping("user")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String login(User user, Model model, HttpServletRequest request) {
//        for (User u : userService.getUsers()) {
//            if (u.getAccount().equals(user.getAccount()) && u.getPassword().equals(user.getPassword())) {
//                HttpSession session = request.getSession();
//                session.setAttribute("user", u);
//                return "redirect:/home/1";
//            }
//        }
//        model.addAttribute("result", "用户名或密码错误！");
//        System.out.println(user);
//        return "login";
//    }
//
//    @RequestMapping("logout")
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.removeAttribute("user");
//        return "redirect:/home/1";
//    }
//
//    @RequestMapping(value = "register", method = RequestMethod.GET)
//    public String register(User user, HttpServletRequest request, Model model) {
//        System.out.println("**********************************register");
//        System.out.println("user:" + user);
//        if (userService.insert(user)) {
//            //用户登录并产生一个session对象
//            User u = userService.queryUserByAccount(user.getAccount());
//            HttpSession session = request.getSession();
//            session.setAttribute("user", u);
//            return "redirect:/home/1";
//        }
//        model.addAttribute("result", "注册失败,用户名已存在");
//        return "register";
//    }
//
//    @RequestMapping(value = "submitDetail", method = RequestMethod.POST)
//    public String submitDetail(HttpServletRequest request, Model model) throws IOException, IOException {
//        long startTime = System.currentTimeMillis();
//        String picUrl = null;
//        String picUris = "";
//
//        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//                request.getSession().getServletContext());
//        //检查form中是否有enctype="multipart/form-data"
//        if (multipartResolver.isMultipart(request)) {
//            //将request变成多部分request
//            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//            //获取multiRequest 中所有的文件名
//            Iterator iter = multiRequest.getFileNames();
////            File uploadDir = new File("D:\\java\\javaEE\\PracticeCode_IDEA\\bluetravel\\src\\main\\webapp\\WEB-INF\\view\\pic");
//            File uploadDir = new File("/home/devin/Documents/pic/");
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//
//            while (iter.hasNext()) {
//                //一次遍历所有文件
//                MultipartFile file = multiRequest.getFile(iter.next().toString());
//                if (file != null) {
//                    String fileName = startTime + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
//                    String picUri = "/home/devin/Documents/pic/" + fileName;
//                    //上传
//                    file.transferTo(new File(picUri));
//                    picUrl = "http://192.168.43.87:8080/pic/" + fileName;
////                    picUri = "D:\\home\\devin\\Documents\\pic\\" + fileName;
////                    picUris = picUris + " " + picUrl;
//                }
//
//            }
//
//        }
//        System.out.println(">>>>>picUrl: " + picUrl);
//        String origin = request.getParameter("origin_province") + request.getParameter("origin_city");
//        String realname = request.getParameter("realname");
//        String sex = request.getParameter("sex");
//        String birthday = request.getParameter("birthday");
//        String idnumber = request.getParameter("idnumber");
//        String tel = request.getParameter("tel");
//        String education = request.getParameter("education");
//        String favoritesnack = request.getParameter("favoritesnack");
//        String selfdescription = request.getParameter("selfdescription");
//
//        //商家属性
//        String address = request.getParameter("address");
//        String majorsnack = request.getParameter("majorsnack");
//        String email = request.getParameter("email");
//
//
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        boolean flag = false;
//        if (user.getRole().equals("consumer")) {
//            UserDetail userDetail = new UserDetail(realname, sex, StringUtil.StringToSQLDate(birthday),
//                    picUrl, origin, Long.parseLong(idnumber), Long.parseLong(tel),
//                    favoritesnack, education, selfdescription, user.getId());
//            flag = userService.updateUserDetail(userDetail);
//        } else if (user.getRole().equals("merchant")) {
//            MerchantDetail merchantDetail = new MerchantDetail(realname, sex, StringUtil.StringToSQLDate(birthday),
//                    picUrl, origin, Long.parseLong(idnumber), Long.parseLong(tel), education, address,
//                    selfdescription, majorsnack, email, user.getId());
//            flag = userService.updateMerchantDetail(merchantDetail);
//        }
//        System.out.print(">>>>>>>>>>>>>>>>submitDetail:" + (flag ? "编辑信息成功！" : "编辑信息失败！"));
//        return "redirect:/home/toUserCenter";
//    }
//
//
//    @RequestMapping("editUserDetail")
//    public String editDetail(HttpServletRequest request) {
//        return "editConsumerBasedInfo";
//    }
//
//    @RequestMapping("editMerchantDetail")
//    public String editRecruitmentDetail(HttpServletRequest request) {
//        return "editMerchantBasedInfo";
//    }
//
//    @RequestMapping("viewDetail")
//    public String viewDetail(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        if (user.getRole().equals("consumer")) {
//            UserDetail userDetail = userService.queryUserDetailById(user.getId());
//            request.setAttribute("userDetail", userDetail);
//            System.out.print(">>>UserDetail:" + userDetail.toString() + ">>>user.getId():" + user.getId());
//
//            return "viewUserBasedInfo";
//        } else if (user.getRole().equals("merchant")) {
//            MerchantDetail merchantDetail = userService.queryMerchantDetailByUserId(user.getId());
//            request.setAttribute("merchantDetail", merchantDetail);
//            System.out.print(">>>merchantDetail:" + merchantDetail.toString() + ">>>>>user.getId():" + user.getId());
//            return "viewMerchantBasedInfo";
//        }
//        System.out.println(">>>>>>>>>viewDetail： 查询baseInfo失败！");
//        return "redirect:/home/1";
//    }
//
//    @RequestMapping("postSnackInfo")
//    public String postJobInfo(Snack snack, HttpServletRequest request, Model model) {
//        String picUris = "";
//
//        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//                request.getSession().getServletContext());
//        //检查form中是否有enctype="multipart/form-data"
//        if (multipartResolver.isMultipart(request)) {
//            //将request变成多部分request
//            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//            //获取multiRequest 中所有的文件名
//            Iterator<String> fileNames = multiRequest.getFileNames();
//
//
//            while (fileNames.hasNext()) {
//                //一次遍历所有文件
//                String fileName = fileNames.next();
//                System.out.println(">>>>>>>>fileName: " + fileName);
////
//                List<MultipartFile> fileList = multiRequest.getFiles(fileName);
//                if (fileList.size() > 0) {
//                    //遍历文件列表
//                    Iterator<MultipartFile> fileIte = fileList.iterator();
//                    while (fileIte.hasNext()) {
//                        //获得每一个文件
//                        MultipartFile multipartFile = fileIte.next();
//                        //获得原文件名
//
//                        long startTime = System.currentTimeMillis();
//                        String singleFilename = startTime + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf('.'));
////
//                        String path = "/home/devin/Documents/pic/";
//                        String filePath = path + singleFilename;
//                        File dir = new File(path);
//                        if (!dir.exists()) {
//                            dir.mkdirs();
//                        }
//
//                        File target = new File(filePath);
//                        try {
//                            multipartFile.transferTo(target);
//                        } catch (IOException e) {
//                            System.err.println("写入文件失败！");
//                        }
////                        picUris = picUris + " " + "http://140.143.10.130:8080/pic/" + singleFilename;
//                        picUris = picUris + " " + "http://192.168.43.87:8080/pic/" + singleFilename;
//                    }
//                }
//
//            }
//
//        }
//
//        System.out.println(">>>>>>>>>>>picUris:" + picUris);

//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        String deliveryaddress = request.getParameter("origin_province") + request.getParameter("origin_city");
//
//        //补充参数
//        snack.setPicurls(picUris);
//        snack.setDeliveryaddress(deliveryaddress);
//        snack.setUserId(user.getId());
//        snack.setId(null);
//        System.out.println(">>>postSnackInfo: " + snack.toString());
//
//        boolean flag = userService.insertSnackInfo(snack);
//        System.out.println("userService.insertPostJobInfo(postJobInfo):"
//                + (flag ? "零食销售信息插入成功！" : "零食销售信息插入失败！"));
//        if (flag) {
//            model.addAttribute("result", "零食销售信息插入成功!");
//        } else {
//            model.addAttribute("result", "零食销售信息插入失败!");
//        }
//        return "redirect:/home/toUserCenter";
//    }
//
//
//    @RequestMapping("addPurchasingList")
//    public String addPurchasingList(SnackAndUser snackAndUser, HttpServletRequest request) {
//        System.out.println("snackId: " + snackAndUser.getSnackId()
//                + " userId: " + snackAndUser.getUserId()
//                + " purchasingCount: " + snackAndUser.getSnackcount());
//        if (StringUtil.isEmpty(snackAndUser.getUserId())) {
//            return "login";
//        }
//        int totalCount = userService.selectCountBySnackId(snackAndUser.getSnackId());
//        Snack snack = new Snack(snackAndUser.getSnackId(), totalCount - snackAndUser.getSnackcount());
//        SnackAndUser snackAndUser1 = userService.selectSnackAndUserByS_IdAndU_Id(snackAndUser);
//        boolean flag, updateCountFlag;
//        if (snackAndUser1 != null) {
//            snackAndUser1.setSnackcount(snackAndUser1.getSnackcount() + snackAndUser.getSnackcount());
//            flag = userService.updatePurchasingCountByPrimaryKey(snackAndUser1);
//            if (flag) {
//                //订单添加成功，零食库存数量对应返回snack表更新
//                updateCountFlag = userService.updateCountBySnackId(snack);
//                if (updateCountFlag) {
//                    try {
//                        throw new Exception("零食库存数量对应返回snack表更新失败，订单添加成功");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            request.setAttribute("result", (flag ? "你已拥有此零食订单，购买数量更新成功！" :
//                    "你已拥有此零食订单，购买数量更新失败！"));
//            return "consumerCenter";
//        }
//        flag = userService.insertSnackAndUserSelective(snackAndUser);
//        if (flag) {
//            updateCountFlag = userService.updateCountBySnackId(snack);
//        }
//        request.setAttribute("result", (flag ? "订单添加成功！" : "订单添加失败！"));
//        return "consumerCenter";
//    }
//
//    @RequestMapping("viewPurchasingList")
//    public String viewPurchasingList(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        List<PurchasingListPojo> pojoList = userService.viewPurchasingList(user.getId());
//        request.setAttribute("pojoList", pojoList);
//        request.setAttribute("result", request.getAttribute("result"));
//        System.out.println(">>>viewPurchasingList: result: " + request.getAttribute("result"));
//        return "purchasingList";
//    }
//
//    @RequestMapping("cancelPurchasing")
//    public ModelAndView cancelPurchasing(SnackAndUser snackAndUser,
//                                         HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("userId: " + snackAndUser.getUserId() + " snackId: " + snackAndUser.getSnackId());
//        boolean flag = userService.cancelPurchasingByUserIdAndSnackId(snackAndUser);
//        if (flag) {
//            request.setAttribute("result", "订单取消成功！");
//        } else {
//            request.setAttribute("result", "订单取消失败！");
//        }
//        System.out.println(">>>userService.cancelPurchasing():" + (flag ? "取消订单成功！" : "取消订单失败！"));
////        request.getRequestDispatcher("/viewPurchasingList").forward(request,response);
//        return new ModelAndView("forward:/user/viewPurchasingList");
//    }
//
//}
