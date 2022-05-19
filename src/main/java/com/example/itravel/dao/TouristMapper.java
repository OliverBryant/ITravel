package com.example.itravel.dao;

import com.example.itravel.entity.Ticket;
import com.example.itravel.entity.Tourist;
import org.apache.ibatis.annotations.Mapper;


import java.sql.Time;
import java.util.Date;
import java.util.List;

@Mapper
public interface TouristMapper {

    List<Tourist> selectTourist(int offset,int limit);

    List<Tourist> selectTouristByName(String name);

    List<Tourist>selectTouristByArea(String area);

    int insertTourist(Tourist tourist);

    int updateTourist(String id,String name, String address, Date openTime,Date closeTime,String intro,String Region);

    int deleteTourist(String touristId);

    int selectNum();
}
