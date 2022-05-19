package com.example.itravel.service;

import com.example.itravel.dao.TouristMapper;
import com.example.itravel.entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class TouristService {

    @Autowired
    private TouristMapper touristMapper;

    public List<Tourist> selectTourist(int offset,int limit) {
        return touristMapper.selectTourist(offset,limit);
    }

    public List<Tourist> selectTouristByName(String name) {
        return touristMapper.selectTouristByName(name);
    }

    public List<Tourist> selectTouristByArea(String area) {
        return touristMapper.selectTouristByArea(area);
    }

    public int updateTourist(String id, String name, String address, Date openTime, Date closeTime, String intro, String Region) {
        return touristMapper.updateTourist(id, name, address, openTime, closeTime, intro, Region);
    }

    public int deletaTourist(String id) {
        return touristMapper.deleteTourist(id);
    }

    public int insert(Tourist tourist) {
        return touristMapper.insertTourist(tourist);
    }

    public int slectNum(){return touristMapper.selectNum();}
}
