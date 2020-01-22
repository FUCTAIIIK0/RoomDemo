package ru.skillbranch.roomdemo.demo2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.skillbranch.roomdemo.dto.RecordDTO;

@Dao
public interface RecordDao {
    @Insert
    RecordDTO add(RecordDTO recordDTO);

    @Query("SELECT * FROM objects")
    List<RecordDTO> getAll();


    RecordDTO getFirst();
    void removeFirs(RecordDTO recordDTO);
}
