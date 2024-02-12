package com.example.retrofitex.rest;

import com.example.retrofitex.Config;
import com.example.retrofitex.rest.Configurations;
import com.example.retrofitex.rest.Movies;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
        private static <T> T builder(Class<T> endpoint){
            return new Retrofit.Builder()
                    .baseUrl(Config.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(endpoint);
        }
        public static Movies movies(){
                return builder(Movies.class);

        }

        public static Configurations configurations(){
            return builder(Configurations.class);
        }
}
