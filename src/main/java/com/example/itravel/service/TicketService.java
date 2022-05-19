package com.example.itravel.service;

import com.example.itravel.dao.TicketMapper;
import com.example.itravel.entity.Ticket;
import org.apache.el.parser.AstFloatingPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketMapper ticketMapper;
    public List<Ticket>selectTicket(){
        return ticketMapper.selectTicket();
    }
    public List<Ticket> selectById(String id) {
        return ticketMapper.selectById(id);
    }
    public int Update(String id){
        return ticketMapper.updateTicket(id);
    }
    public int insert(Ticket ticket){
        return ticketMapper.insert(ticket);
    }
    public int update111(Object id,int num, float price,String type){
        return ticketMapper.update111(id,num,price,type);
    }
    public int deleteById(String tid, String name){
        return ticketMapper.deleteById(tid,name);
    }
}
