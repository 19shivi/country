package com.shivam.country.Network;

import com.shivam.country.model.Country;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Apiroute {
    @Headers("Content-Type: application/json")
    @GET("asia")
    Call<List<Country>> getAllCountry();

}
