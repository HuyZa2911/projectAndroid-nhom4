package com.example.quanlykhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_fragment);
    }
}