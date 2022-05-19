package com.example.itravel.service;

import com.example.itravel.dao.DirectorMapper;
import com.example.itravel.entity.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DirectorService {

    @Autowired
    private DirectorMapper directorMapper;

    public Map<String, Object> login(String account, String password) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(account + "        " + password);
        Director director = directorMapper.selectByAccount(account);
//        System.out.println(director.getPassword());
        if(account==null||password==null){
            map.put("notNullMsg", "用户名或密码不能为空");
            return map;
        }else{
            if (director == null) {
                map.put("usernameMsg", "该账户不存在");
                return map;
            }
            else if(!director.getPassword().equals(password)){
                map.put("passwordMsg", "密码不正确");
                return map;
            }
            else{
                map.put("success", "1");
                map.put("account", account);
                return map;
            }
        }
    }

    public int updateInfo(String account, String name, String phone, String email) {
        return directorMapper.updateInfo(account, name, phone, email);
    }

    public Director selectByAccount(String account) {
        return directorMapper.selectByAccount(account);
    }

    public int updatePassword(String account, String password) {
        return directorMapper.updatePassword(account, password);
    }
}
