package com.example.retrofitex.rest;

import com.example.retrofitex.model.configuration.ConfigurationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Configurations {
    @GET("/configuration")
    Call<ConfigurationResponse> configurations(@Query("apikey") String apikey);

}
