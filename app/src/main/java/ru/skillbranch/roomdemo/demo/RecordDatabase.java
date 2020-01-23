package ru.skillbranch.roomdemo.demo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.skillbranch.roomdemo.entity.Record;

@Database(entities = {Record.class}, version = 1, exportSchema = false)
public abstract class RecordDatabase extends RoomDatabase {
    public abstract RecordDao testDao();
}
