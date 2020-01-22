package ru.skillbranch.roomdemo.dto;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "objects")
public class RecordDTO {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "added")
    private Date added;

    @ColumnInfo(name = "serializeObject")
    private String serializeObject;

    public RecordDTO(Long id, Date added, Object object) {
        this.id = id;
        this.added = added;
        this.setObject(object);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getAdded() {
        return added;
    }
    public void setAdded(Date added) {
        this.added = added;
    }

    public Object getObject() {
        return serializeObject;
    }

    public void setObject(Object object) {
        this.serializeObject = serializeObject;
    }
}
