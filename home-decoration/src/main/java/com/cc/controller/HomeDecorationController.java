package com.cc.controller;

import com.cc.model.Contract;
import com.cc.model.GalleryDesign;
import com.cc.model.Page;
import com.cc.service.UserService;
import com.cc.util.StringUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("homeDecoration")
public class HomeDecorationController {

    private final static String tag = "com.cc.controller.HomeDecorationController";

    public final static int PageSize = 2;

    @Autowired
    UserService userService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home() {
        return "guide";
    }

    @RequestMapping(value = "gallery", method = RequestMethod.GET)
    public String gallery(HttpServletRequest request) {
        //设置默认筛选条件的json字符串
        String str = "{\"houseType\":\"\",\"cost\":\"\",\"area\":\"\",\"style\":\"\"}";
        JSONObject jsonObject = JSONObject.fromObject(str);

        Map<String, Object> map = userService.filteGalleryDesignByPage(jsonObject, new Page());
        List<GalleryDesign> galleryDesignList = (List<GalleryDesign>) map.get("galleryDesignList");
        Page pageObject = (Page) map.get("pageObject");

        request.setAttribute("galleryDesignList", galleryDesignList);
        request.setAttribute("pageObject", pageObject);
        return "gallery";
    }

    @RequestMapping(value = "toLogin")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "toRegister")
    public String register() {
        return "register";
    }


    @RequestMapping("decorationTips")
    public String decorationTips(HttpServletRequest request) {
        return "decorationTips";
    }

    @RequestMapping(value = "filteGalleryDesign", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> filteGalleryDesign(@RequestBody String jsonString) {
        System.out.println(tag + ":  filteGalleryDesign:  jsonString: " + jsonString);
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map<String, Object> map = userService.filteGalleryDesignByPage(jsonObject, new Page());
        return map;

    }

    @RequestMapping("filteGalleryDesignByPageNum")
    @ResponseBody
    public Map<String, Object> filteGalleryDesignByPageNum(@Param("jsonObject") String jsonObject, @Param("pageNum") Integer pageNum) {
        System.out.println(tag + ":  filteGalleryDesignByPageNum:  jsonObject: " + jsonObject + "  pageNum: " + pageNum);
        JSONObject js = JSONObject.fromObject(jsonObject);
        Map<String, Object> map = userService.filteGalleryDesignByPage(js, new Page(pageNum, PageSize));
        return map;
    }
}
