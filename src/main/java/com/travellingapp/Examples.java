package com.travellingapp;

import org.hibernate.SessionFactory;

public class Examples {

    private static SessionFactory factory;

    public static void main(String[] args) {
        DataStore dataStore = new PostgresDB();
        User user1 = new User("Domi", "domidomi");
        dataStore.save(user1);
        dataStore.close();
    }
}
