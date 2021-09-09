package com.shivam.country.viewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shivam.country.Network.Apiroute;
import com.shivam.country.Network.RetrofitInstance;
import com.shivam.country.RoomeDatabase.CountryRepository;
import com.shivam.country.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryListModelView extends AndroidViewModel {
    private CountryRepository countryRepository;
    MutableLiveData<List<Country>> mutableData = new MutableLiveData<List<Country>>();
    public MutableLiveData<List<Country>> DataObserver() {
        return mutableData;
    }
    public CountryListModelView(@NonNull Application application) {
        super(application);
        countryRepository=new CountryRepository(application);
        mutableData.postValue(countryRepository.getAllCountry());

    }





    public void getAllCountries() {
        Apiroute apiService = RetrofitInstance.getClient().create(Apiroute.class);
        Call<List<Country>> call = apiService.getAllCountry();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                for (Country c : response.body())
                    countryRepository.insert(c);
                mutableData.postValue(response.body());
                Log.v("api", response.body().toString());

            }

            public void onFailure(Call<List<Country>> call, Throwable t) {
                mutableData.postValue(countryRepository.getAllCountry());
                Log.v("error", t.toString());
            }

        });
    }
  public  void delete()
  {
      countryRepository.delete();
      mutableData.postValue(countryRepository.getAllCountry());
  }



}
