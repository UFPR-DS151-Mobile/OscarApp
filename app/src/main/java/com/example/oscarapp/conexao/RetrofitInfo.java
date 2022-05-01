package com.example.oscarapp.conexao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInfo {
     private Retrofit r;

    public  Retrofit getRetrofitInstance() {

        if (this.r == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            String linkApi = "https://www.getpostman.com/collections/5516faec97c2658aebd2";
            this.r = new Retrofit.Builder()
                    .baseUrl(linkApi)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return this.r;

    }

}

