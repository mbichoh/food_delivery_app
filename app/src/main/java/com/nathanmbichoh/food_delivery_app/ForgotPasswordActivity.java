package com.nathanmbichoh.food_delivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextView txtBtnBack;
    private EditText txtEmailAddress;
    private Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        txtBtnBack = (TextView) findViewById(R.id.txtBack);
        txtEmailAddress = (EditText) findViewById(R.id.emailTxt);
        btnSendEmail    = (Button) findViewById(R.id.btnSend);

        txtBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
            }
        });
    }
}
