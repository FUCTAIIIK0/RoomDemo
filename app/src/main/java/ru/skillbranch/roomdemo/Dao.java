package ru.skillbranch.roomdemo;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
//    @Query("SELECT * FROM UserDTO")
//    List<UserDTO> getAll();
//
//    @Query("SELECT * FROM UserDTO WHERE id = :id")
//    UserDTO getById(long id);

    @Insert
    void insert(UserDTO employee);

    @Update
    void update(UserDTO employee);

    @Delete
    void delete(UserDTO employee);
}
