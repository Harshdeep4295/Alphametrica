package com.xavi.thealphametrica.viewModel;

import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.xavi.thealphametrica.R;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.fragment.NavHostFragment;

public class NewUserViewModel extends ViewModel {

    public MutableLiveData<String> Name = new MutableLiveData<>("");
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>("");
    public MutableLiveData<String> Password = new MutableLiveData<>("");
    public MutableLiveData<String> RePassword = new MutableLiveData<>("");
    public MutableLiveData<String> PhoneNumber = new MutableLiveData<>("");
    public MutableLiveData<String> DOB = new MutableLiveData<>("");
    public MutableLiveData<Boolean> set8char = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> setSpecialChar = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> setOneUpperCase = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> setOneNumber = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> agreeTermsAndCondition = new MutableLiveData<>(false);
    private Fragment mFragment;

    private MutableLiveData<NewUserViewModel> userMutableLiveData;

    public MutableLiveData<NewUserViewModel> getNewUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<NewUserViewModel>();
        }
        return userMutableLiveData;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }


    public void register(View view) {

        if (!Patterns.EMAIL_ADDRESS.matcher(EmailAddress.getValue()).matches()) {
            Toast.makeText(view.getContext(), "Please enter valid email", Toast.LENGTH_LONG).show();
            return;
        } else if (!set8char.getValue() || !setOneNumber.getValue() || !setOneUpperCase.getValue() || !setSpecialChar.getValue()) {
            Toast.makeText(view.getContext(), "Password does not satisfy the criteria.", Toast.LENGTH_LONG).show();
            return;

        } else if (!Password.getValue().equals(RePassword.getValue())) {
            Toast.makeText(view.getContext(), "Password does not match", Toast.LENGTH_LONG).show();
            return;
        } else if (!agreeTermsAndCondition.getValue()) {
            Toast.makeText(view.getContext(), "Please accept terms and condition", Toast.LENGTH_LONG).show();
            return;
        } else if (!checkAllFields()) {
            Toast.makeText(view.getContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        } else {
            Toast.makeText(view.getContext(), "Registration done, Login to continue", Toast.LENGTH_LONG).show();
            NavHostFragment.findNavController(mFragment).navigateUp();

        }
    }

    private boolean checkAllFields() {
        return !DOB.getValue().isEmpty() && !PhoneNumber.getValue().isEmpty();
    }

    public void navigateToLogin(View view){
        NavHostFragment.findNavController(mFragment).navigate(R.id.action_RegisterFragment_to_LoginFragment);
    }
}
