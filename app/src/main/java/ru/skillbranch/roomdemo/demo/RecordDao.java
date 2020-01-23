package ru.skillbranch.roomdemo.demo;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.skillbranch.roomdemo.dto.RecordDTO;

@androidx.room.Dao
public interface RecordDao {
    @Query("SELECT * FROM object")
    List<RecordDTO> getAll();

    @Query("SELECT * FROM object WHERE id = :id")
    RecordDTO getById(int id);

    @Query("SELECT *FROM object WHERE id = 1")
    RecordDTO getFirst();

    @Insert
    void addRecord(RecordDTO recordDTO);


    @Update
    void update(RecordDTO recordDTO);

    @Delete
    void delete(RecordDTO recordDTO);
}
