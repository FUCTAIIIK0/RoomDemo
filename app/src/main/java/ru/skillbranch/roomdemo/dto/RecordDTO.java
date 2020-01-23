package ru.skillbranch.roomdemo.dto;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "object")
public class RecordDTO {

    @NotNull
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "serializeObject")
    private String serializeObject;

    public RecordDTO() {

    }

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getSerializeObject() {
        return serializeObject;
    }
    public void setSerializeObject(String serializeObject) {
        this.serializeObject = serializeObject;
    }

}
