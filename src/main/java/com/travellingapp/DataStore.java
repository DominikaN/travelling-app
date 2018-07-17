package com.travellingapp;

public interface DataStore {
    Long save(User userToSave);
    void close();
}
