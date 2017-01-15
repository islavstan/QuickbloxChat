package com.islavstan.chatmvp.points;

import com.islavstan.chatmvp.models.login.AnswerForLogin;
import com.islavstan.chatmvp.models.login.LogModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;



public interface LoginPoint {
    @Headers({
            "Content-Type: application/json",
            "QuickBlox-REST-API-Version: 0.1.0"
    })
    @POST("/session.json")
    Call<AnswerForLogin> getSessionWithLogin(@Body LogModel user);

}