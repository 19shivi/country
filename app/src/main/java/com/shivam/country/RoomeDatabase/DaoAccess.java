package com.shivam.country.RoomeDatabase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.shivam.country.model.Country;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoAccess {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Country country);

    @Query("DELETE FROM country_table")
    void deleteAll();

    @Query("SELECT * FROM country_table ORDER BY name ASC")
    List<Country> getAllCountry();
}
