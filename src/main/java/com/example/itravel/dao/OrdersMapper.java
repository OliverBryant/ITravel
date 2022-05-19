package com.example.itravel.dao;

import com.example.itravel.entity.OrdersInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {

    List<OrdersInfo> selectAll();

    List<OrdersInfo> selectByPhone(String phone);

    List<OrdersInfo>selectByName(String name);

}
