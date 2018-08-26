package com.varad.mvpauthentication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.varad.mvpauthentication.R;
import com.varad.mvpauthentication.model.PresenterImpl;
import com.varad.mvpauthentication.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private PresenterImpl mLoginPresenter;

    @BindView(R.id.emailEditText)
    EditText emailEditText;

    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @BindView(R.id.loginButton)
    Button loginButton;

    @BindView(R.id.registerLinkTextView)
    TextView registerLinkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLoginPresenter = new PresenterImpl(this);
    }

    @OnClick(R.id.loginButton)
    public void clickLoginButton() {
        String emailInput = emailEditText.getText().toString().trim();
        String passwordInput = passwordEditText.getText().toString().trim();
        mLoginPresenter.processLogin(emailInput, passwordInput);

    }

    @OnClick(R.id.registerLinkTextView)
    public void clickRegisterLink() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginValidation() {
        Toast.makeText(this, "Enter all above fields", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }
}
