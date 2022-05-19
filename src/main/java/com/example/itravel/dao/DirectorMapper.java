package com.example.itravel.dao;

import com.example.itravel.entity.Director;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface DirectorMapper {

    Director selectByAccount(String account);

    int updateInfo(String account,String name,String phone,String email);

    int updatePassword(String account,String password);

}
