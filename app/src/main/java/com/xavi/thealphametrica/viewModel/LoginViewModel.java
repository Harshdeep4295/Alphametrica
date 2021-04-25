package com.xavi.thealphametrica.viewModel;

import android.view.View;
import android.widget.Toast;

import com.xavi.thealphametrica.Model.LoginUser;
import com.xavi.thealphametrica.R;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.fragment.NavHostFragment;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>("");
    public MutableLiveData<String> Password = new MutableLiveData<>("");
    private MutableLiveData<LoginViewModel> userModel = new MutableLiveData<>();
    public MutableLiveData<Boolean> ValidEmail = new MutableLiveData<>();
    public MutableLiveData<Boolean> UserLoggedIn = new MutableLiveData<>(false);
    public Fragment fragment;

    public MutableLiveData<LoginViewModel> getUser() {

        if (userModel == null) {
            userModel = new MutableLiveData<>();

        }
        return userModel;
    }

    public void setCurrentFragment(Fragment fragment){
        this.fragment = fragment;
    }
    public void forgetPassword(View view) {
        Toast.makeText(view.getContext(), "Not Implemented Yet", Toast.LENGTH_SHORT).show();
    }

    public void signIn(View view) {
        String email = EmailAddress.getValue();
        String password = Password.getValue();
        LoginUser user = new LoginUser(email, password);

        if (user.isAnyFieldEmpty()) {
            Toast.makeText(view.getContext(), "Please enter both email & password.", Toast.LENGTH_LONG).show();
            return;
        } else if (!user.validCredentials()) {
            Toast.makeText(view.getContext(), "Invalid email or password.", Toast.LENGTH_LONG).show();
            return;
        } else {
            UserLoggedIn.postValue(true);
        }
    }

    public void register(View view){
        NavHostFragment.findNavController(fragment)
                .navigate(R.id.action_login_to_RegisterFragment);
    }


}
