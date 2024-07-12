package com.example.quizapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import  retrofit
public class RetroServer {
    private static final String baseURL = "https://diniikuu.000webhostapp.com/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retro;
    }
}
