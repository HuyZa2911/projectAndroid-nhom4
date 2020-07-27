package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykhachsan.fragment.HomeAdminFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginLayout extends AppCompatActivity {
    public static String ADMIN ="ADMIN";
    public static String USER ="USER";

    String role = USER;
    Button btnLogin;
    Intent intent;
    EditText etAcount, etPassword;
    String TAG="FIREBASE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_layout);
        btnLogin = findViewById(R.id.btnLogin);
        btnClickLogin();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


    }

    private void btnClickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (role.equals(LoginLayout.ADMIN)){
                    intent = new Intent(LoginLayout.this, HomeAdminLayout.class);
                }
                if (role.equals(LoginLayout.USER)){
                    intent = new Intent(LoginLayout.this,HomeUserLayout.class);
                }
                startActivity(intent);
            }
        });

    }
}
