package ru.skillbranch.roomdemo.demo;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.skillbranch.roomdemo.entity.Record;

@androidx.room.Dao
public interface RecordDao {
    @Query("SELECT * FROM object")
    List<Record> getAll();

    @Query("SELECT * FROM object WHERE id = :id")
    Record getById(int id);

    @Query("SELECT *FROM object WHERE id = 1")
    Record getFirstByID();

    @Query("SELECT * FROM object ORDER BY date DESC LIMIT 1")
    Record getFirstRecordByTime();

    @Insert
    void addRecord(Record record);


    @Update
    void update(Record record);

    @Delete
    void delete(Record record);
}
