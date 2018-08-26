package com.varad.mvpauthentication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.varad.mvpauthentication.R;
import com.varad.mvpauthentication.model.PresenterImpl;
import com.varad.mvpauthentication.view.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private PresenterImpl mRegisterPresenter;

    @BindView(R.id.nameEditText)
    EditText nameEditText;

    @BindView(R.id.emailEditText)
    EditText emailEditText;

    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @BindView(R.id.registerButton)
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mRegisterPresenter = new PresenterImpl(this);
    }

    @OnClick(R.id.registerButton)
    public void clickRegisterButton() {
        String nameInput = nameEditText.getText().toString().trim();
        String emailInput = emailEditText.getText().toString().trim();
        String passwordInput = passwordEditText.getText().toString().trim();
        mRegisterPresenter.processRegistration(nameInput, emailInput, passwordInput);
    }

    @Override
    public void registerValidation() {
        Toast.makeText(this, "Enter all above fields", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess() {
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerError() {

    }
}
