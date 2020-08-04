package com.example.quanlykhachsan;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykhachsan.models_data.KhachHang;
import com.example.quanlykhachsan.models_data.KhachSan;
import com.example.quanlykhachsan.models_data.Login;
import com.example.quanlykhachsan.models_data.TaiKhoan;
import com.example.quanlykhachsan.models_manage_data.ListKhachHang;
import com.example.quanlykhachsan.models_manage_data.ListKhachSan;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class LayoutRegistration extends AppCompatActivity {
    EditText edtName, edtPhone, edtPass, edtPassConfirm;
    Button btnSignUp, btnCancel;
    String sName, sPhone, sPass, sPassConfirm, sMail;
    ArrayList<TaiKhoan> taiKhoanArrayList = new ArrayList<TaiKhoan>();
    boolean bFlagIsPhone = false;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.sing_up_account);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtPassConfirm = (EditText) findViewById(R.id.confirmPass);
        btnSignUp = findViewById(R.id.btnConfirm);
        btnCancel = findViewById(R.id.btnCancel);


        database.child("account").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                taiKhoanArrayList.clear();
                bFlagIsPhone = false;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    taiKhoanArrayList.add(dataSnapshot.getValue(TaiKhoan.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sName = edtName.getText().toString();
                sPhone = edtPhone.getText().toString();
                sPass = edtPass.getText().toString();
                sPassConfirm = edtPassConfirm.getText().toString();
                sMail = null;

                if (sName.length() != 0 && sPhone != null && sPass.length() != 0 && sPassConfirm.length() != 0) {
                    if (sPhone.length() >= 8) {
                        bFlagIsPhone = false;
                        for (TaiKhoan taiKhoan : taiKhoanArrayList) {
                            if (taiKhoan.getPhone().equals(sPhone)) {
                                bFlagIsPhone = true;
                                break;
                            }

                        }

                        if (sPassConfirm.equals(sPass)) {
                            if (bFlagIsPhone == true) {
                                Toast.makeText(LayoutRegistration.this, "Số điện thoại đã được sử dụng", Toast.LENGTH_SHORT).show();
                                edtPhone.requestFocus();

                            } else {
                                Toast.makeText(LayoutRegistration.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                TaiKhoan taiKhoan = new TaiKhoan(sName, sPass, sPhone, 0);

                                database.child("account").push().setValue(taiKhoan);
                                Intent intent = LoginLayout.intent;
                                intent = new Intent(LayoutRegistration.this, LoginLayout.class);

                                intent.putExtra("name", taiKhoan.getUserName());
                                intent.putExtra("phone", taiKhoan.getPhone());
                                intent.putExtra("pass", taiKhoan.getPass());
                                startActivity(intent);
                            }
                        } else {
                            Toast.makeText(LayoutRegistration.this, "Mật khẩu xác nhận không chính xác", Toast.LENGTH_SHORT).show();
                            edtPass.setText("");
                            edtPassConfirm.setText("");
                            edtPass.requestFocus();

                        }
                    } else {
                        Toast.makeText(LayoutRegistration.this, "Số điện thoại phải lớn hơn 8 và nhỏ hơn 11", Toast.LENGTH_SHORT).show();
                        edtPhone.requestFocus();

                    }
                } else {
                    Toast.makeText(LayoutRegistration.this, "Không được để một trong các trường dữ liệu", Toast.LENGTH_SHORT).show();
                    edtName.requestFocus();
                }


            }
        });

    }
}
