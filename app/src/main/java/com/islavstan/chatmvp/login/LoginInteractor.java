package com.islavstan.chatmvp.login;


import android.content.Context;

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onError();

        void onSuccess();

        void tokenToast(String toast);
    }

    void login(String username, String password, OnLoginFinishedListener listener);


}