package ru.skillbranch.roomdemo.dto;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity(tableName = "objects")
public class RecordDTO {

    @NotNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "added")
    private String added;

    @ColumnInfo(name = "serializeObject")
    private String serializeObject;

    public RecordDTO() {
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAdded() {
        return added;
    }
    public void setAdded(String added) {
        this.added = added;
    }

    public String getSerializeObject() {
        return serializeObject;
    }
    public void setSerializeObject(String serializeObject) {
        this.serializeObject = serializeObject;
    }
}
