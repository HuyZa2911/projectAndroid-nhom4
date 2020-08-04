package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykhachsan.models_data.Login;
import com.example.quanlykhachsan.models_data.TaiKhoan;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class LoginLayout extends AppCompatActivity {
    public static String ADMIN = "ADMIN";
    public static String USER = "USER";



 public static Intent intent ;
    TaiKhoan taikhoan;

    String role = USER;
    Button btnLogin;

    TextView lblRegistration;
    EditText etAcount, etPassword;
    private DatabaseReference database;
    boolean kt = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_layout);
        btnLogin = findViewById(R.id.btnLogin);
        lblRegistration = findViewById(R.id.lblRegistration);
        etAcount = findViewById(R.id.etAcount);
        etPassword = findViewById(R.id.etPassword);
        btnClickLogin();
        Registration();
        intent = getIntent();
        String numberPhone = intent.getStringExtra("phone");
        if(numberPhone != null){
            etAcount.setText(numberPhone);
        }
    }


    private void btnClickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                database = FirebaseDatabase.getInstance().getReference();
                database.child("account").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                        TaiKhoan taikhoan = snapshot.getValue(TaiKhoan.class);
                        if (etAcount.getText().toString().equals(taikhoan.getPhone()) && etPassword.getText().toString().equals(taikhoan.getPass())) {
//                            Toast.makeText(LoginLayout.this,snapshot.getKey(),Toast.LENGTH_SHORT).show();
                            if (taikhoan.getRole() == 1) {
                                intent = new Intent(LoginLayout.this, HomeAdminLayout.class);
                                intent.putExtra("id",snapshot.getKey());
                                intent.putExtra("name",taikhoan.getUserName());
                                intent.putExtra("phone",taikhoan.getPhone());
//                                intent.putExtra("email",taikhoan.getMail());
                            } else {
                                intent = new Intent(LoginLayout.this, HomeUserLayout.class);
                                intent.putExtra("id",snapshot.getKey());
                                intent.putExtra("name",taikhoan.getUserName());
                                intent.putExtra("phone",taikhoan.getPhone());
//                                intent.putExtra("email",taikhoan.getMail());
                            }
                            kt = true;
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                setButtonLogin(etAcount.getText().toString(),etPassword.getText().toString());

            }
        });
    }
    private void Registration() {
        lblRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginLayout.this, LayoutRegistration.class);
                startActivity(intent);
            }
        });
    }
    private long backPressTime;


    @Override
    public void onBackPressed() {

        if (backPressTime + 2000 > System.currentTimeMillis()) {
            finishAffinity();
            System.exit(0);
        } else {
            Toast.makeText(LoginLayout.this, R.string.toatsExit, Toast.LENGTH_SHORT).show();
        }
        backPressTime = System.currentTimeMillis();
    }
    private void setButtonLogin(final String userName, final String password){
        database = FirebaseDatabase.getInstance().getReference();
        database.child("account").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                if (snapshot.child(userName).exists()){
                    if (!userName.isEmpty()){
                        TaiKhoan taikhoan = snapshot.child(userName).getValue(TaiKhoan.class);
                        if (password.equals(taikhoan.getPass())){
                            if (taikhoan.getRole() == 1) {
                                    intent = new Intent(LoginLayout.this, HomeAdminLayout.class);
                                    intent.putExtra("id", userName);
                                    intent.putExtra("name", taikhoan.getUserName());
                                    intent.putExtra("phone", taikhoan.getPhone());
                                    intent.putExtra("email", taikhoan.getMail());
                                } else {
                                    intent = new Intent(LoginLayout.this, HomeUserLayout.class);
                                    intent.putExtra("id", userName);
                                    intent.putExtra("name", taikhoan.getUserName());
                                    intent.putExtra("phone", taikhoan.getPhone());
                                    intent.putExtra("email", taikhoan.getMail());
                            }
                                startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginLayout.this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(LoginLayout.this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
