package com.example.itravel.dao;

import com.example.itravel.entity.OrderStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderStatusMapper {

    public List<OrderStatus> selectView();

    public List<OrderStatus> selectSum();

}
