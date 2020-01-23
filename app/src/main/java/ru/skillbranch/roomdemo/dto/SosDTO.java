package ru.skillbranch.roomdemo.dto;

import java.util.Date;

public class SosDTO {
    private String sosID;
    private Boolean online;
    private String userName;
    private Date date;

    public SosDTO(){}

    public SosDTO(String sosID, Boolean online, String userID, String userName, Date date) {
        this.sosID = sosID;
        this.online = online;
        this.userName = userName;
        this.date = date;
    }

    public String getSosID() {
        return sosID;
    }
    public void setSosID(String sosID) {
        this.sosID = sosID;
    }

    public Boolean getOnline() {
        return online;
    }
    public void setOnline(Boolean online) {
        this.online = online;
    }



    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }




}
