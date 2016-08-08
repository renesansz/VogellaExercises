package com.example.renesansz.stackoverflow.interfaces;

import com.example.renesansz.stackoverflow.models.StackOverflowQuestions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class StackOverflowAPI {

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    public Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags) {
        return null;
    }

}
