package com.example.itravel.controller;


import com.example.itravel.entity.OrderStatus;
import com.example.itravel.entity.OrdersInfo;
import com.example.itravel.entity.Tourist;
import com.example.itravel.service.OrderStatusService;
import com.example.itravel.service.OrdersService;
import com.example.itravel.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping(path = "/orderIfn",method = RequestMethod.GET)
    public String getOrderPage(Model model){

        List<OrdersInfo> list = ordersService.selectAll();
        List<Map<String, Object>> maps = new ArrayList<>();
        if(list!=null){
            for(OrdersInfo t:list){
                Map<String,Object> map = new HashMap<>();
                map.put("ordersInfo",t);
                maps.add(map);
            }
        }
        model.addAttribute("ordersInfo1",maps);
        System.out.println(maps);
        return "order_info";
    }
//    方法定义处：进一步细分请求映射
    @RequestMapping(path = "/operating",method = RequestMethod.GET)
    public  String getStatus(Model model){
//        景点售票额度和售票数目
        List<OrderStatus> list1=orderStatusService.selectView();
//        售票总数 售票总额 订单总数
        List<OrderStatus> list2=orderStatusService.selectSum();
//        数据传给界面
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
//        返回状态?
        return "status";
    }


    @RequestMapping(path = "/orderIfn/{searchId}", method = RequestMethod.GET)
    public String search(Model model,@PathVariable("searchId") String searchId,String phone,String name){
        List<OrdersInfo> list;
        if (searchId.equals("search3")) {
            list = ordersService.selectByPhone(phone);
        }
        else {
            list=ordersService.selectByName(name);
        }

        List<Map<String, Object>> maps = new ArrayList<>();
        if(list!=null){
            for(OrdersInfo t:list){
                Map<String,Object> map = new HashMap<>();
                map.put("ordersInfo",t);
                maps.add(map);
            }
        }
        model.addAttribute("ordersInfo1",maps);
        return "order_info";
    }

}
