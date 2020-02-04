package com.example.peopeletech.retrofit;


import com.example.peopeletech.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {


    @GET("facts")
    Call<Info> getPeople(@Query("format") String format);
}
