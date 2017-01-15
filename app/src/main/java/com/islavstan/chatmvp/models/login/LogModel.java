package com.islavstan.chatmvp.models.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by islav on 15.01.2017.
 */

public class LogModel {
    @SerializedName("application_id")
    String appId;
    @SerializedName("auth_key")
    String auth_key;
    @SerializedName("timestamp")
    String timestamp;
    @SerializedName("nonce")
    String nonce;
    @SerializedName("signature")
    String signature;
    @SerializedName("user")
    LogAndPas LogAndPas;

    public LogModel(String appId, String auth_key, String timestamp, String nonce, String signature, LogAndPas LogAndPas) {
        this.appId = appId;
        this.auth_key = auth_key;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.LogAndPas = LogAndPas;
        this.signature = signature;
    }
}

