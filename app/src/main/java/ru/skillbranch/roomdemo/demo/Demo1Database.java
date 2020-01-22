package ru.skillbranch.roomdemo.demo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.skillbranch.roomdemo.dto.UserDTO;

@Database(entities = {UserDTO.class}, version = 1, exportSchema = false)
public abstract class Demo1Database extends RoomDatabase {


    public abstract Dao testDao();
}
