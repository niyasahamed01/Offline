package com.niyas.sample.room;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class RoomDatabaseManager {
    private static RoomDatabaseManager instance;
    private final AppDatabase database;

    private RoomDatabaseManager(Context context) {
        database = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "person-database")
                .allowMainThreadQueries()
                .build();
    }

    public static synchronized RoomDatabaseManager getInstance(Context context) {
        if (instance == null) {
            instance = new RoomDatabaseManager(context);
        }
        return instance;
    }

    public void insertPerson(String name, int age, int rollNumber) {
        Person person = new Person(name, age, rollNumber);
        database.personDao().insert(person);
    }

    public List<Person> getAllPersons() {
        return database.personDao().getAllPersons();
    }

    public Person getPersonById(int id) {
        return database.personDao().getPersonById(id);
    }

    public void deletePerson(Person person) {
        database.personDao().delete(person);
    }
}