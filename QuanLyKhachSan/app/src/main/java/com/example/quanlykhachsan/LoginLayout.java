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

    String role = USER;
    Button btnLogin;
    Intent intent;
    TextView lblRegistration;
    EditText etAcount, etPassword;
    private DatabaseReference database;
    boolean kt = false;
    ArrayList<Login> tk = new ArrayList<Login>();

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
        final Intent intent1 = getIntent();
        String numberPhone = intent1.getStringExtra("sPhone");
        if (numberPhone != null) {
            etAcount.setText(numberPhone);
        }
        setButtonLogin();
    }


    private void btnClickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!kt(etAcount.getText().toString(), etPassword.getText().toString())) {
                    Toast.makeText(LoginLayout.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
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

    //    private void setButtonLogin(final String userName, final String password){
//        database = FirebaseDatabase.getInstance().getReference();
//        database.child("account").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange( DataSnapshot snapshot) {
//                if (snapshot.child(userName).exists()){
//                    if (!userName.isEmpty()){
//                        TaiKhoan taikhoan = snapshot.child(userName).getValue(TaiKhoan.class);
//                        if (password.equals(taikhoan.getPass())){
//                            if (taikhoan.getRole() == 1) {
//                                    intent = new Intent(LoginLayout.this, HomeAdminLayout.class);
//                                    intent.putExtra("id", userName);
//                                    intent.putExtra("name", taikhoan.getUserName());
//                                    intent.putExtra("phone", taikhoan.getPhone());
//                                    intent.putExtra("email", taikhoan.getMail());
//                                } else {
//                                    intent = new Intent(LoginLayout.this, HomeUserLayout.class);
//                                    intent.putExtra("id", userName);
//                                    intent.putExtra("name", taikhoan.getUserName());
//                                    intent.putExtra("phone", taikhoan.getPhone());
//                                    intent.putExtra("email", taikhoan.getMail());
//                            }
//                                startActivity(intent);
//                        }
//                        else {
//                            Toast.makeText(LoginLayout.this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }else {
//                    Toast.makeText(LoginLayout.this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }
    private boolean kt(String phone, String pass) {
        for (int i = 0; i < tk.size(); i++) {
            if (tk.get(i).getPhone().equals(phone) && tk.get(i).getPass().equals(pass)) {
                if (tk.get(i).getRole() == 1) {
                    intent = new Intent(LoginLayout.this, HomeAdminLayout.class);
                                    intent.putExtra("id", tk.get(i).getIdChuKS());
                                    intent.putExtra("name", tk.get(i).getUserName());
                                    intent.putExtra("phone", tk.get(i).getPhone());
                                    intent.putExtra("email", tk.get(i).getMail());
                } else {
                    intent = new Intent(LoginLayout.this, HomeUserLayout.class);
                                    intent.putExtra("id", tk.get(i).getIdChuKS());
                                    intent.putExtra("name", tk.get(i).getUserName());
                                    intent.putExtra("phone", tk.get(i).getPhone());
                                    intent.putExtra("email", tk.get(i).getMail());
                }
                startActivity(intent);
                return true;
            }
        }
        return false;
    }

    private void setButtonLogin() {
        database = FirebaseDatabase.getInstance().getReference();
        database.child("account").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String idchuKS = snapshot.getKey();
                TaiKhoan taikhoan = snapshot.getValue(TaiKhoan.class);
                tk.add(new Login(idchuKS,taikhoan.getUserName(), taikhoan.getPass(), taikhoan.getPhone(), taikhoan.getMail(), taikhoan.getRole()));
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

    }
}
