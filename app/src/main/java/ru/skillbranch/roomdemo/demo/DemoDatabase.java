package ru.skillbranch.roomdemo.demo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.skillbranch.roomdemo.dto.RecordDTO;

@Database(entities = {RecordDTO.class}, version = 1, exportSchema = false)
public abstract class DemoDatabase extends RoomDatabase {

    public abstract DemoDao testDao();
}
