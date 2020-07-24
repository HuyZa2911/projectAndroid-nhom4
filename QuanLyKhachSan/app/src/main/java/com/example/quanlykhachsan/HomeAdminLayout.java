package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlykhachsan.fragment.HomeAdminFragment;
import com.example.quanlykhachsan.fragment.ListWaitFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeAdminLayout extends AppCompatActivity {
    LinearLayout layoutFragment;
    BottomNavigationView buttonMenu;
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_admin);
        buttonMenu = findViewById(R.id.bottom_hotelier_navagition);
        layoutFragment = findViewById(R.id.layout_admin);
        swapContentFragment(HomeAdminFragment.newInstance(), true, R.id.layout_admin);
        setButtonMenu();

    }

    public void setButtonMenu() {
        buttonMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                        Toast.makeText(HomeAdminLayout.this, "Thông tin", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
    }
    public void swapContentFragment(final Fragment i_newFragment, final boolean i_addToStack, final int container) {
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(container, i_newFragment);
        if (!i_addToStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
