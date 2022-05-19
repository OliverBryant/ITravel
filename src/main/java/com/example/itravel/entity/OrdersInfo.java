package com.example.itravel.entity;

import javax.xml.crypto.Data;
import java.security.Timestamp;
import java.sql.Time;

public class OrdersInfo {

    private String userPhone;
    private String userName;
    private float orderTicketPrice;
    private String orderTouristName;
    private String orderTicketTypeName;
    private int purchasNums;
    private float sumPrice;
    private String orderTime;
    private int orderStatus;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getOrderTicketPrice() {
        return orderTicketPrice;
    }

    public void setOrderTicketPrice(float orderTicketPrice) {
        this.orderTicketPrice = orderTicketPrice;
    }

    public String getOrderTouristName() {
        return orderTouristName;
    }

    public void setOrderTouristName(String orderTouristName) {
        this.orderTouristName = orderTouristName;
    }

    public String getOrderTicketTypeName() {
        return orderTicketTypeName;
    }

    public void setOrderTicketTypeName(String orderTicketTypeName) {
        this.orderTicketTypeName = orderTicketTypeName;
    }

    public int getPurchasNums() {
        return purchasNums;
    }

    public void setPurchasNums(int purchasNum) {
        this.purchasNums = purchasNum;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {

        String S;
        if(orderStatus==0)
            S="未完成";
        else
            S="已完成";
        return S;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrdersInfo{" +
                "userPhone='" + userPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", orderTicketPrice=" + orderTicketPrice +
                ", orderTouristName='" + orderTouristName + '\'' +
                ", orderTicketTypeName='" + orderTicketTypeName + '\'' +
                ", purchasNums=" + purchasNums +
                ", sumPrice=" + sumPrice +
                ", orderTime=" + orderTime +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
