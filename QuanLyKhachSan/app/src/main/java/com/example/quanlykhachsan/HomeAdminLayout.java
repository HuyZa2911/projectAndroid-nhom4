package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlykhachsan.fragment.HomeAdminFragment;
import com.example.quanlykhachsan.fragment.InformationFragment;
import com.example.quanlykhachsan.fragment.ListHottelFragment;
import com.example.quanlykhachsan.fragment.ListWaitFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeAdminLayout extends AppCompatActivity {
    LinearLayout layoutFragment;
    BottomNavigationView navMenu;
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
            setContentView(R.layout.layout_admin);
            navMenu = findViewById(R.id.bottom_hotelier_navagition_admin);
            layoutFragment = findViewById(R.id.layout_admin);
            swapContentFragment(HomeAdminFragment.newInstance(), true, R.id.layout_admin);
            setMenuAdmin();

    }

    private void setMenuAdmin() {
        navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        swapContentFragment(HomeAdminFragment.newInstance(), true, R.id.layout_admin);
                        Toast.makeText(HomeAdminLayout.this, "home", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.manage_room:
                        Toast.makeText(HomeAdminLayout.this, "Quản lý phòng", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.list_wait:
                        swapContentFragment(ListWaitFragment.newInstance(), true, R.id.layout_admin);
                        Toast.makeText(HomeAdminLayout.this, "Danh sách chờ", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.information:
                        swapContentFragment(InformationFragment.newInstance(), true, R.id.layout_admin);
                        Toast.makeText(HomeAdminLayout.this, "Thông tin", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void setMenuUser(){
        navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        swapContentFragment(ListHottelFragment.newInstance(), true, R.id.layout_user);
                    return true;
                    case R.id.search:
                        Toast.makeText(HomeAdminLayout.this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
                    case R.id.history:
                        Toast.makeText(HomeAdminLayout.this, "Thông tin", Toast.LENGTH_SHORT).show();
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
