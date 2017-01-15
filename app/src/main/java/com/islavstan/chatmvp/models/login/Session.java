package com.islavstan.chatmvp.models.login;

import com.google.gson.annotations.SerializedName;

public class Session{
   @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }
}
