package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlykhachsan.fragment.HomeAdminFragment;
import com.example.quanlykhachsan.fragment.InformationFragment;
import com.example.quanlykhachsan.fragment.ListHottelFragment;
import com.example.quanlykhachsan.fragment.ListRoomFragment;
import com.example.quanlykhachsan.fragment.ListWaitFragment;
import com.example.quanlykhachsan.models_data.KhachSan;
import com.example.quanlykhachsan.models_data.TaiKhoan;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeAdminLayout extends AppCompatActivity {
    LinearLayout layoutFragment;
    BottomNavigationView navMenu;
    Intent intent;
    String idAcount,name,phone,email,diachi,idKS;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_admin);
        navMenu = findViewById(R.id.bottom_hotelier_navagition_admin);
        layoutFragment = findViewById(R.id.layout_admin);
        setMenuAdmin();
        intent = getIntent();
        idAcount = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        phone= intent.getStringExtra("phone");
        email= intent.getStringExtra("email");

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("khachsan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                KhachSan ks = snapshot.getValue(KhachSan.class);
                if(intent.getStringExtra("id").equals(ks.getIdChuKS())){
                    idKS = snapshot.getKey();
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

        swapContentFragment(HomeAdminFragment.newInstance(idAcount), true, R.id.layout_admin);
//            DatabaseReference database = FirebaseDatabase.getInstance().getReference();
//             KhachSan ks = new KhachSan(idAcount,"abc","thu duc",4);
//            database.child("khachsan").push().setValue(ks);
    }

    private void setMenuAdmin() {
        navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        swapContentFragment(HomeAdminFragment.newInstance(idAcount), true, R.id.layout_admin);
                        Toast.makeText(HomeAdminLayout.this, "home", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.manage_room:
                        Toast.makeText(HomeAdminLayout.this, "Quản lý phòng", Toast.LENGTH_SHORT).show();
                        swapContentFragment(ListRoomFragment.newInstance(idKS), true, R.id.layout_admin);
                        return true;
                    case R.id.list_wait:
                        swapContentFragment(ListWaitFragment.newInstance(), true, R.id.layout_admin);
                        Toast.makeText(HomeAdminLayout.this, "Danh sách chờ", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.information:
                        swapContentFragment(InformationFragment.newInstance(name,phone,email), true, R.id.layout_admin);
                        Toast.makeText(HomeAdminLayout.this, "Thông tin", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
    }


    private void swapContentFragment(final Fragment i_newFragment, final boolean i_addToStack, final int container) {
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(container, i_newFragment);
        if (!i_addToStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
