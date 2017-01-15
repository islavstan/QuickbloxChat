package com.islavstan.chatmvp.models.login;

import com.google.gson.annotations.SerializedName;



public class AnswerForLogin {
    @SerializedName("session")
Session session;

    public Session getSession() {
        return session;
    }
}

