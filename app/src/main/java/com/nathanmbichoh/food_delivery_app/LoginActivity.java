package com.nathanmbichoh.food_delivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.TimeZone;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText txtUsername, txtPassword;
    private TextView txtForgotPassword, txtSignUp, txtHello;
    private Button btnLogin, btnLoginWithGoogle, btnLoginWithFb;

    String today;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = (TextInputEditText) findViewById(R.id.usernameTxt);
        txtPassword = (TextInputEditText) findViewById(R.id.passwordTxt);

        txtForgotPassword = (TextView) findViewById(R.id.txtForgotPword);
        txtSignUp         = (TextView) findViewById(R.id.txtSignUp);
        txtHello          = (TextView) findViewById(R.id.txtHello);

        btnLogin             = (Button) findViewById(R.id.btnLogin);
        btnLoginWithGoogle   = (Button) findViewById(R.id.signInWithGoogle);
        btnLoginWithFb       = (Button) findViewById(R.id.signInWithFb);

        //welcome
        //get today's day
        today = "Thursday";
        txtHello.setText("Hello, It\'s "+today+"!");

        //forgot pword
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });

        //signUp
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        //login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainPageActivity.class));
            }
        });

        //login with google
        btnLoginWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //login with facebook
        btnLoginWithFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
