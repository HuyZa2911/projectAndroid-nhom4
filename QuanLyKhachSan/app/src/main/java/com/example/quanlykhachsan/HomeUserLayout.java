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

import com.example.quanlykhachsan.fragment.HistoryFragment;
import com.example.quanlykhachsan.fragment.InformationFragment;
import com.example.quanlykhachsan.fragment.ListHottelFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeUserLayout extends AppCompatActivity {
    LinearLayout layoutFragment;
    BottomNavigationView navMenu;
    Intent intent;
    String idAcount,name,phone,email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_user);
        navMenu = findViewById(R.id.bottom_hotelier_navagition_user);
        layoutFragment = findViewById(R.id.layout_user);
        swapContentFragment(ListHottelFragment.newInstance(), true, R.id.layout_user);
        setMenuUser();
        intent = getIntent();
        idAcount = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        phone= intent.getStringExtra("phone");
        email= intent.getStringExtra("email");
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
                        Toast.makeText(HomeUserLayout.this, "Update versition 2.0", Toast.LENGTH_SHORT).show();
                        swapContentFragment(SearchFragment.newInstance(), true, R.id.layout_user);
                        return true;
                    case R.id.history:
                        swapContentFragment(HistoryFragment.newInstance(idAcount), true, R.id.layout_user);
                        return true;
                    case R.id.information:
                        swapContentFragment(InformationFragment.newInstance(name,phone,email), true, R.id.layout_user);
                        return true;
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
