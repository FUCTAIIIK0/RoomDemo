package ru.skillbranch.roomdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserDTO.class}, version = 1, exportSchema = false)
public abstract class TestDatabase extends RoomDatabase {


    public abstract Dao testDao();
}
