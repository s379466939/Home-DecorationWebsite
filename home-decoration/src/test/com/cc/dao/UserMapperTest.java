package com.cc.dao;

import com.cc.model.User;
import com.cc.model.UserExample;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml", "classpath:mybatis-cfg.xml"})
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectByExample() {
        List<User> list = userMapper.selectByExample(new UserExample());
        Assert.assertTrue(list.size() == 0);
    }


}