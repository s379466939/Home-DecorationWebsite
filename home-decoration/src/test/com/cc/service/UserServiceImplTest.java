package com.cc.service;

import com.cc.model.GalleryDesign;
import com.cc.model.Page;
import com.cc.model.ReserveDecoration;
import com.cc.model.User;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml", "classpath:mybatis-cfg.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void hasAccount() {
    }

    @Test
    public void testGetUserByAccount() {
        User user = new User();
        user.setAccount("Devin");
        User u = userService.getUserByAccount(user);
        System.out.println(u.toString());
    }

    @Test
    public void testGetAllReservationsByUserId() {
        List<ReserveDecoration> list = userService.getAllReservationsByUserId(2);
        Assert.assertEquals(0,list.size());
        Assert.assertNotNull(list);
        System.out.println(list);
    }

    @Test
    public void testFilteGalleryDesign(){
        String str = "{\"houseType\":\"\",\"cost\":\"3~15\",\"area\":\"10~20\",\"style\":\"\"}";
        JSONObject jsonObject = JSONObject.fromObject(str);
        List<GalleryDesign> list = userService.filteGalleryDesign(jsonObject);
        System.out.println(list);
    }

    @Test
    public void testFilteGalleryDesignByPage(){

        String str = "{\"houseType\":\"\",\"cost\":\"5~10\",\"area\":\"0~80\",\"style\":\"简约\"}";
        JSONObject jsonObject = JSONObject.fromObject(str);
        Map<String,Object> map = userService.filteGalleryDesignByPage(jsonObject, new Page(1,2));
    }
}