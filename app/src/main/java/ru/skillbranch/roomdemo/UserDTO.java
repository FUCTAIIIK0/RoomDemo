package ru.skillbranch.roomdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "user")
public class UserDTO {

    @NotNull
    @PrimaryKey
    private String id;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    @ColumnInfo(name = "status")
    private Boolean isOnline;

    @ColumnInfo(name = "cityID")
    private String cityID;

    @ColumnInfo(name = "companyID")
    private String companyID;



    public UserDTO(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Boolean getOnline() {
        return isOnline;
    }
    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getCityID() {
        return cityID;
    }
    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCompanyID() {
        return companyID;
    }
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
