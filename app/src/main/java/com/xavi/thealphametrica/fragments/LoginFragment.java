package com.xavi.thealphametrica.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xavi.thealphametrica.R;
import com.xavi.thealphametrica.databinding.FragmentLoginBinding;
import com.xavi.thealphametrica.viewModel.LoginViewModel;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding mBinding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        loginViewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel.class);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        mBinding.setLifecycleOwner(this);
        loginViewModel.getUser().getValue();
        mBinding.setLoginViewModel(loginViewModel);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel.setCurrentFragment(this);
    }

}