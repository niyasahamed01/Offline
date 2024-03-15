package com.niyas.sample.room;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM persons")
    List<Person> getAllPersons();

    @Query("SELECT * FROM persons WHERE id = :id")
    Person getPersonById(int id);

    @Insert
    void insert(Person person);

    @Delete
    void delete(Person person);

}
