package com.example.itravel.service;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)

@SpringBootTest
public class DsTest {
    @Autowired
    private DirectorService ds ;
    private String acc;
    private String psw;
    @Test
    public void login() {
        acc="2019214266";
        psw="miaoyifan";
        Map<String, Object> map1 = new HashMap<>();
        map1.put("success", "1");
        map1.put("account", acc);
        assertEquals(map1,ds.login(acc,psw));

        acc="2019214";
        psw="miaoyifan";
        Map<String, Object> map2 = new HashMap<>();
        map2.put("usernameMsg", "该账户不存在");
        assertEquals(map2,ds.login(acc,psw));

        acc="2019214266";
        psw="miaoyi";
        Map<String, Object> map3 = new HashMap<>();
        map3.put("passwordMsg", "密码不正确");
        assertEquals(map3,ds.login(acc,psw));

        acc=null;
        psw="miaoyi";
        Map<String, Object> map4 = new HashMap<>();
        map4.put("notNullMsg", "用户名或密码不能为空");
        assertEquals(map4,ds.login(acc,psw));
        
        acc="2019214266";
        psw=null;
        Map<String, Object> map5 = new HashMap<>();
        map5.put("notNullMsg", "用户名或密码不能为空");
        assertEquals(map5,ds.login(acc,psw));
    }
}