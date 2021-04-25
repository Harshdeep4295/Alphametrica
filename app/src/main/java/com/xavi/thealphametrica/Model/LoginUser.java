package com.xavi.thealphametrica.Model;

import android.util.Patterns;

public class LoginUser {
    private String emailAddress;
    private String password;

    public LoginUser(String emailAddress,String pass){
        this.emailAddress = emailAddress;
        this.password = pass;
    }

    public boolean isAnyFieldEmpty(){
        return emailAddress.isEmpty() &&  password.isEmpty();
    }

    public boolean validCredentials(){
        return emailAddress.trim().equals("test@luxpmsoft.com") && password.trim().equals("test1234!");
    }
}
