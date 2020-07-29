package com.example.quanlykhachsan;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykhachsan.models_data.TaiKhoan;
import com.example.quanlykhachsan.models_manage_data.ListKhachHang;
import com.example.quanlykhachsan.models_manage_data.ListKhachSan;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LayoutRegistration extends AppCompatActivity {
    EditText edtName, edtPhone, edtPass, edtPassConfirm;
    Button btnSignUp, btnCancel;
    String sName, sPhone, sPass, sPassConfirm, sMail;

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

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = edtName.getText().toString();
                sPhone = edtPhone.getText().toString();
                sPass = edtPass.getText().toString();
                sPassConfirm = edtPassConfirm.getText().toString();
                sMail = null;

                if (sName != null && sPhone != null && sPass != null && sPassConfirm != null) {
                    if (sPhone.length() == 9) {

                        if (sPass.equals(sPassConfirm)) {

                            final DatabaseReference database = FirebaseDatabase.getInstance().getReference();

                            database.child("account").addChildEventListener(new ChildEventListener() {
                                boolean bFlag = false;

                                @Override
                                public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                                    TaiKhoan taiKhoan1 = snapshot.getValue(TaiKhoan.class);
                                    ListKhachHang arrKh = new ListKhachHang();
                                    arrKh.setListCustomer(taiKhoan1);
                                    for (TaiKhoan tk : arrKh.getListCustomer()) {
                                        if (tk.getPhone().toString().equals(sPhone)) {
                                            Toast.makeText(LayoutRegistration.this, "Số điện thoại đã được sử dụng!", Toast.LENGTH_LONG).show();
                                            bFlag = true;
                                            break;
                                        }
                                    }
                                    if(bFlag==false) {
                                        TaiKhoan taiKhoan = new TaiKhoan(sName, sPass, sPhone, sMail, 0);
                                        database.child("account").push().setValue(taiKhoan);
                                        Intent intent = new Intent(LayoutRegistration.this, LoginLayout.class);
                                        intent.putExtra("sPhone", sPhone);
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


                        } else {
                            Toast.makeText(LayoutRegistration.this, "Mật khẩu xác nhận không chính xác, vui lòng nhập lại!", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(LayoutRegistration.this, "Số điện thoại nhỏ hơn 10 số, vui lòng nhập lại!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }


}
