package ru.skillbranch.roomdemo.demo2;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.skillbranch.roomdemo.dto.RecordDTO;

@Database(entities = {RecordDTO.class}, version = 1, exportSchema = false)

public abstract class RecordDB extends RoomDatabase {
    public abstract Dao iManager();
}
