package ru.skillbranch.roomdemo.demo2;

import androidx.room.Dao;
import androidx.room.Insert;

import ru.skillbranch.roomdemo.dto.RecordDTO;

@androidx.room.Dao
public interface RecordDao {
    @Insert
    RecordDTO add(RecordDTO recordDTO);


    RecordDTO getFirst();
    void removeFirs(RecordDTO recordDTO);
}
