package com.xavi.thealphametrica.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xavi.thealphametrica.R;

public class WelcomeFragment extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.loginButton).setOnClickListener(this::login);
        view.findViewById(R.id.signUpButton).setOnClickListener(this::signUp);

    }

    private void login(View view) {
        NavHostFragment.findNavController(WelcomeFragment.this)
                .navigate(R.id.navigate_to_Login);
    }

    private void signUp(View view) {
        NavHostFragment.findNavController(WelcomeFragment.this)
                .navigate(R.id.navigate_to_Register);
    }
}