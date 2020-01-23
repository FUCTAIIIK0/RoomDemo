package ru.skillbranch.roomdemo.demo;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.skillbranch.roomdemo.dto.RecordDTO;

@androidx.room.Dao
public interface DemoDao {
    @Query("SELECT * FROM object")
    List<RecordDTO> getAll();


//    @Query("SELECT * FROM USER WHERE uid = :id")
//    RecordDTO getById(long id);
    @Insert
    void addUser(RecordDTO recordDTO);



    @Update
    void update(RecordDTO recordDTO);

    @Delete
    void delete(RecordDTO recordDTO);
}
