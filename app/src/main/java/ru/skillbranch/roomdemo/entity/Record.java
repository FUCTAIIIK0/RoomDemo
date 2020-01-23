package ru.skillbranch.roomdemo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity(tableName = "object")
public class Record {

    @NotNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date")
    private int date;

    @ColumnInfo(name = "serializeObject")
    private String serializeObject;

    @ColumnInfo(name = "ObjectType")
    private String objectType;

    public Record() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getSerializeObject() {
        return serializeObject;
    }
    public void setSerializeObject(String serializeObject) {
        this.serializeObject = serializeObject;
    }

    public String getObjectType() {
        return objectType;
    }
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
