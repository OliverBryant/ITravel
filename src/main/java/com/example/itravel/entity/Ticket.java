package com.example.itravel.entity;

public class Ticket {

    private String ticketid;
    private String TouristAttractionID;
    private float ticketprice;
    private int maxnums;
    private String type;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketid='" + ticketid + '\'' +
                ", TouristAttractionID='" + TouristAttractionID + '\'' +
                ", ticketprice=" + ticketprice +
                ", maxnums=" + maxnums +
                ", type='" + type + '\'' +
                '}';
    }

    public Ticket(String ticketid, String touristAttractionID, float ticketprice, int maxnums, String type) {
        this.ticketid = ticketid;
        TouristAttractionID = touristAttractionID;
        this.ticketprice = ticketprice;
        this.maxnums = maxnums;
        this.type = type;
    }

    public Ticket(String touristAttractionID, float ticketprice, int maxnums, String type) {
        TouristAttractionID = touristAttractionID;
        this.ticketprice = ticketprice;
        this.maxnums = maxnums;
        this.type = type;
    }

    public Ticket(String touristAttractionID, float ticketprice, int maxnums) {
        TouristAttractionID = touristAttractionID;
        this.ticketprice = ticketprice;
        this.maxnums = maxnums;
    }

    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }

    public String getTouristAttractionID() {
        return TouristAttractionID;
    }

    public void setTouristAttractionID(String touristAttractionID) {
        TouristAttractionID = touristAttractionID;
    }

    public float getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(float ticketprice) {
        this.ticketprice = ticketprice;
    }

    public int getMaxnums() {
        return maxnums;
    }

    public void setMaxnums(int maxnums) {
        this.maxnums = maxnums;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
