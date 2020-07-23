package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class LoginFragment extends AppCompatActivity {
    Button btnLogin;
    Intent intent;
    EditText etAcount, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.control_hotel_background);
//      btnLogin = findViewById(R.id.btnLogin);
//        btnClickLogin();

// Write a message to the database

    }

    private void btnClickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginFragment.this, TestDialog.class);
                startActivity(intent);
            }
        });

    }
}