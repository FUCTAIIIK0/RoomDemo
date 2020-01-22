package ru.skillbranch.roomdemo.ss;

public interface IManager {
    Record add(Object object);
    Record getFirst();
    void removeFirs(Record record);
}
