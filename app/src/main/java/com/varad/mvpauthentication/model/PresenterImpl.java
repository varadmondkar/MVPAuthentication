package com.varad.mvpauthentication.model;

import android.text.TextUtils;

import com.varad.mvpauthentication.presenter.LoginPresenter;
import com.varad.mvpauthentication.presenter.RegisterPresenter;
import com.varad.mvpauthentication.view.LoginView;
import com.varad.mvpauthentication.view.RegisterView;

/**
 * Created by varad on 25/08/18.
 */
public class PresenterImpl implements LoginPresenter, RegisterPresenter {

    private LoginView mLoginView;
    private RegisterView mRegisterView;

    public PresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    public PresenterImpl(RegisterView registerView) {
        this.mRegisterView = registerView;
    }

    public PresenterImpl(LoginView mLoginView, RegisterView registerView) {
        this.mLoginView = mLoginView;
        this.mRegisterView = registerView;
    }

    @Override
    public void processLogin(String emailInput, String passwordInput) {

        if (TextUtils.isEmpty(emailInput) || TextUtils.isEmpty(passwordInput)) {
            mLoginView.loginValidation();
        } else {

            if (emailInput.equals("varad") && passwordInput.equals("varad")) {
                mLoginView.loginSuccess();
            } else {
                mLoginView.loginError();
            }
        }
    }

    @Override
    public void processRegistration(String nameInput, String emailInput, String passwordInput) {
        if (TextUtils.isEmpty(nameInput) || TextUtils.isEmpty(emailInput) || TextUtils.isEmpty(passwordInput)) {
            mRegisterView.registerValidation();
        } else {
            mRegisterView.registerSuccess();
        }
    }
}
