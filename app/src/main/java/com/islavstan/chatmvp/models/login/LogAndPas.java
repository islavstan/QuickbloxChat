package com.islavstan.chatmvp.models.login;

import com.google.gson.annotations.SerializedName;

public class LogAndPas {
   @SerializedName("login")
   String login;
   @SerializedName("password")
   String password;

   public LogAndPas(String login, String password) {
       this.login = login;
       this.password = password;
   }
}
