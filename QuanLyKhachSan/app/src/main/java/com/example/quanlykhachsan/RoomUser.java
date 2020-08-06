package com.example.quanlykhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlykhachsan.fragment.ListWaitFragment;
import com.example.quanlykhachsan.fragment.UserListHottelFragment;

public class RoomUser extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_room_user);
        setTitle("Khách sạn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intent = getIntent();
        String idChuKS = intent.getStringExtra("idKhachSan");
        String idUSer = intent.getStringExtra("idUserBooking");
        swapContentFragment(UserListHottelFragment.newInstance(idChuKS,idUSer), true, R.id.fargment_user_room);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
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
