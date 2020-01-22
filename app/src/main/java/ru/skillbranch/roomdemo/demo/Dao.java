package ru.skillbranch.roomdemo.demo;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.skillbranch.roomdemo.dto.UserDTO;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM USER")
    List<UserDTO> getAll();


//    @Query("SELECT * FROM USER WHERE uid = :id")
//    UserDTO getById(long id);
    @Insert
    void addUser(UserDTO userDTO);



    @Update
    void update(UserDTO userDTO);

    @Delete
    void delete(UserDTO userDTO);
}
