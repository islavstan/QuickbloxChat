package com.islavstan.chatmvp.login;



public interface LoginView {
    void showProgress();

    void hideProgress();

    void setError();

    void navigateToContacts();

    void showToken(String token);

    void navigateToRegistration();
}

