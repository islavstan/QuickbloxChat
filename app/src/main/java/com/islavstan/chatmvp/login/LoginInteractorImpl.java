package com.islavstan.chatmvp.login;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import com.islavstan.chatmvp.api.ApiClient;
import com.islavstan.chatmvp.models.login.AnswerForLogin;
import com.islavstan.chatmvp.models.login.LogAndPas;
import com.islavstan.chatmvp.models.login.LogModel;
import com.islavstan.chatmvp.models.login.Session;
import com.islavstan.chatmvp.points.LoginPoint;
import com.islavstan.chatmvp.tools.HmacSha1Signature;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {
    private Long tsLong = System.currentTimeMillis() / 1000;
    private String ts = tsLong.toString();
    private int randonId = new Random().nextInt();
    private String signature;
    private String token;

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... strings) {
                signature = HmacSha1Signature.signatureForLogin(randonId, ts, username, password);
                final LoginPoint apiService = ApiClient.getRetrofit().create(LoginPoint.class);


                Log.d("stas", "timestamp = " + ts);
                Log.d("stas", "nonce = " + Integer.toString(randonId));
                Log.d("stas", "signature = " + signature);

                Call<AnswerForLogin> call = apiService.getSessionWithLogin(new LogModel("52262", "Mer3vGU4AOrw2zc", ts, Integer.toString(randonId), signature, new LogAndPas(username, password)));
                call.enqueue(new Callback<AnswerForLogin>() {
                    @Override
                    public void onResponse(Call<AnswerForLogin> call, Response<AnswerForLogin> response) {
                        if (response.isSuccessful()) {
                            AnswerForLogin answer = response.body();
                            token = answer.getSession().getToken();
                            listener.tokenToast(token);
                            listener.onSuccess();
                            Log.d("stas", token);

                        } else {
                            try {
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
                                Log.d("stas", jObjError.getString("errors"));
                                token = jObjError.getString("errors");
                                listener.tokenToast(token);
                                listener.onError();
                            } catch (Exception e) {
                                Log.d("stas", e.getMessage());
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<AnswerForLogin> call, Throwable t) {

                    }
                });


                return token;
            }

        }.execute();
    }
}
