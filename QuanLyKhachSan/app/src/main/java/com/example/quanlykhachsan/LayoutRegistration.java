package com.example.quanlykhachsan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutRegistration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.sing_up_account);
    }
}
