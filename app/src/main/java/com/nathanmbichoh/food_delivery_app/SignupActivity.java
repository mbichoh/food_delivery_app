package com.nathanmbichoh.food_delivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignUp;
    private TextInputEditText txtPassword, txtEmail, txtPhone, txtName;

    private TextView txtGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignUp   = (Button) findViewById(R.id.btnSignUp);

        txtPassword = (TextInputEditText) findViewById(R.id.passwordTxt);
        txtPhone    = (TextInputEditText) findViewById(R.id.phoneTxt);
        txtEmail    = (TextInputEditText) findViewById(R.id.verityTxt);
        txtName     = (TextInputEditText) findViewById(R.id.usernameTxt);

        //alternative go back to login window
        txtGoBack   = (TextView) findViewById(R.id.txtBack);
        txtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        //signing up
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "We are going to deal this in a while!", Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
