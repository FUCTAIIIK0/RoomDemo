package ru.skillbranch.roomdemo.ss;

import java.util.Date;

public class Record {
    private Long id;
    private Date added;
    private String serializeObject;

    public Record(Long id, Date added, Object object) {
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
