package com.islavstan.chatmvp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.islavstan.chatmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    EditText login, password;
    Button loginBtn;
    ProgressBar progressBar;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.enterBtn);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        loginPresenter = new LoginPresenterImpl(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginClick();
            }
        });


    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void navigateToContacts() {
        Toast.makeText(this, "ContactActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToken(String token) {
        Toast.makeText(this, "token = " + token, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToRegistration() {

    }

    public void loginClick() {
        String log = login.getText().toString();
        String pas = password.getText().toString();
        if (!log.equals("") && !pas.equals("")) {
            loginPresenter.validateCredentials(log, pas);
        } else
            Toast.makeText(LoginActivity.this, "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show();
    }


}
