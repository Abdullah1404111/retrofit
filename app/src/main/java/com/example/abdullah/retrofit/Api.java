package com.example.abdullah.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "https://api.github.com/";

    @GET("users/{user_id}")

    Call<Hero>getHeroes(@Path("user_id") String str);
}
