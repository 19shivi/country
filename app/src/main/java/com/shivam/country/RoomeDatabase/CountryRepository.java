package com.shivam.country.RoomeDatabase;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shivam.country.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountryRepository  {

    private DaoAccess daoAccess;
    private List<Country> mAllCountry;


    public CountryRepository(Application application) {
        CountryDatabase db = CountryDatabase.getDatabase(application);
        daoAccess = db.daoAccess();
        mAllCountry = daoAccess.getAllCountry();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
   public List<Country> getAllCountry() {
        return daoAccess.getAllCountry();
    }

  public    void insert(Country country) {
        CountryDatabase.databaseWriteExecutor.execute(() -> {
            daoAccess.insert(country);
        });
    }
 public   void delete()
    {

            daoAccess.deleteAll();


    }
}