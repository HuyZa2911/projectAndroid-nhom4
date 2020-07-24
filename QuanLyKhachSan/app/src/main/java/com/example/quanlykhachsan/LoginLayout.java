package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykhachsan.fragment.HomeAdminFragment;


public class LoginLayout extends AppCompatActivity {
    Button btnLogin;
    Intent intent;
    EditText etAcount, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_layout);
        btnLogin = findViewById(R.id.btnLogin);
        btnClickLogin();


    }

    private void btnClickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginLayout.this, HomeAdminLayout.class);
                startActivity(intent);
            }
        });

    }
}
