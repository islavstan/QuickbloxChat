package com.islavstan.chatmvp.login;



public interface LoginPresenter {
    void validateCredentials(String username, String password);
    void onDestroy();
}

