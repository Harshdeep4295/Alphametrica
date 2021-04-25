package com.xavi.thealphametrica.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xavi.thealphametrica.R;
import com.xavi.thealphametrica.databinding.FragmentRegisterBinding;
import com.xavi.thealphametrica.viewModel.NewUserViewModel;

import java.util.regex.Pattern;


public class RegisterFragment extends Fragment {

    private NewUserViewModel newUserViewModel;
    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        newUserViewModel = ViewModelProviders.of(this).get(NewUserViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        binding.setLifecycleOwner(this);
        newUserViewModel.getNewUser().getValue();
        binding.setNewUserViewModel(newUserViewModel);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newUserViewModel.setFragment(this);
        newUserViewModel.Password.observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable final String password) {
                     
                        newUserViewModel.set8char.postValue(hasLength(password));
                        newUserViewModel.setOneUpperCase.postValue(hasUpperCase(password));
                        newUserViewModel.setOneNumber.postValue(hasDigits(password));
                        newUserViewModel.setSpecialChar.postValue(hasSymbols(password));

                    }
                }
        );

    }

    private static boolean hasLength(String data) {
        return String.valueOf(data).length() >= 8;
    }

    private static boolean hasUpperCase(String data) {
        String password = String.valueOf(data);
        return !password.equals(password.toLowerCase());
    }

    private static boolean hasDigits(String data) {
        String digit = "(.*\\d.*)";
        return Pattern.matches(digit, data);
    }

    private static boolean hasSymbols(String data) {
        String symbol = "(.*[:?!@#$%^&*()].*)";
        return Pattern.matches(symbol, data);
    }
}