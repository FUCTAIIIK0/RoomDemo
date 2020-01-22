package ru.skillbranch.roomdemo;

import java.util.Date;

public class SosDTO {
    private String sosID;
    private Boolean online;
    private String userID;
    private String userName;
    private Date date;

    public SosDTO(){}

    public SosDTO(String sosID, Boolean online, String userID, String userName, Date date) {
        this.sosID = sosID;
        this.online = online;
        this.userID = userID;
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

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
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
