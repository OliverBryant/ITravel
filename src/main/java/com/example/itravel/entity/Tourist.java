package com.example.itravel.entity;

import java.util.Date;
import java.sql.Time;

public class Tourist {

    private String touristattractionid;
    private String touristattractionname;
    private String address;
    private Date openingTime;
    private Date closeTime;
    private String introduction;
    private String regionname;
    private int adultnum;
    private float adultprice;
    private int studentnum;
    private float studentprice;
    private int childnum;
    private float childprice;
    private int oldnum;
    private float oldprice;

    public Tourist() {

    }

    public Tourist(String touristattractionid, String touristattractionname, String address, Date openingTime, Date closeTime, String introduction, String regionname) {
        this.touristattractionid = touristattractionid;
        this.touristattractionname = touristattractionname;
        this.address = address;
        this.openingTime = openingTime;
        this.closeTime = closeTime;
        this.introduction = introduction;
        this.regionname = regionname;
    }

    public String getTouristattractionid() {
        return touristattractionid;
    }

    public void setTouristattractionid(String touristattractionid) {
        this.touristattractionid = touristattractionid;
    }

    public String getTouristattractionname() {
        return touristattractionname;
    }

    public void setTouristattractionname(String touristattractionname) {
        this.touristattractionname = touristattractionname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public int getAdultnum() {
        return adultnum;
    }

    public void setAdultnum(int adultnum) {
        this.adultnum = adultnum;
    }

    public float getAdultprice() {
        return adultprice;
    }

    public void setAdultprice(float adultprice) {
        this.adultprice = adultprice;
    }

    public int getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(int studentnum) {
        this.studentnum = studentnum;
    }

    public float getStudentprice() {
        return studentprice;
    }

    public void setStudentprice(float studentprice) {
        this.studentprice = studentprice;
    }

    public int getChildnum() {
        return childnum;
    }

    public void setChildnum(int childnum) {
        this.childnum = childnum;
    }

    public float getChildprice() {
        return childprice;
    }

    public void setChildprice(float childprice) {
        this.childprice = childprice;
    }

    public int getOldnum() {
        return oldnum;
    }

    public void setOldnum(int oldnum) {
        this.oldnum = oldnum;
    }

    public float getOldprice() {
        return oldprice;
    }

    public void setOldprice(float oldprice) {
        this.oldprice = oldprice;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "touristattractionid='" + touristattractionid + '\'' +
                ", touristattractionname='" + touristattractionname + '\'' +
                ", address='" + address + '\'' +
                ", openingTime=" + openingTime +
                ", closeTime=" + closeTime +
                ", introduction='" + introduction + '\'' +
                ", regionname='" + regionname + '\'' +
                ", adultnum=" + adultnum +
                ", adultprice=" + adultprice +
                ", studentnum=" + studentnum +
                ", studentprice=" + studentprice +
                ", childnum=" + childnum +
                ", childprice=" + childprice +
                ", oldnum=" + oldnum +
                ", oldprice=" + oldprice +
                '}';
    }
}
