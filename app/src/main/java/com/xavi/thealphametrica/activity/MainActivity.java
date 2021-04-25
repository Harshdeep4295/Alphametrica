package com.xavi.thealphametrica.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.xavi.thealphametrica.R;
import com.xavi.thealphametrica.viewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoginViewModel loginViewModel =  ViewModelProviders.of(this).get(LoginViewModel.class);


        loginViewModel.UserLoggedIn.observe(this, aBoolean -> {
            if(aBoolean)
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
        });
    }
}