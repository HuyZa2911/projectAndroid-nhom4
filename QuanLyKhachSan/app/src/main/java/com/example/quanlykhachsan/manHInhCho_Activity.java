package com.example.quanlykhachsan;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykhachsan.Data.KhachHang;

import java.util.ArrayList;

public class manHInhCho_Activity extends AppCompatActivity {
    private ListView lvKhachHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_man_hinh_cho_layout);
        lvKhachHang = (ListView) findViewById(R.id.lvKhachHang);
        ArrayList<KhachHang> arrKhachHang = new ArrayList<>();
        KhachHang khachHang1 = new KhachHang(1 ,"Nguyen Van A", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
                8);
        KhachHang khachHang2 = new KhachHang(2 ,"Nguyen Van B", "123456", "12/5/2002", "12/8/2019", "so 4 Tu Duc",
                8);
        KhachHang khachHang3 = new KhachHang(3,"Nguyen Van An", "123456", "12/5/2003", "12/8/2019", "so 4 Thu Duc",
                8);
        KhachHang khachHang4 = new KhachHang(4,"Nguyen Van Anh", "123456", "12/5/2001", "12/8/2019", "so 4 Thu",
                8);
        KhachHang khachHang5 = new KhachHang(5,"Nguyen Van D", "123456", "12/5/2002", "12/8/2019", "so 4 Tan Duc",
                8);
        KhachHang khachHang6 = new KhachHang(6,"Nguyen Van E", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
                8);
        KhachHang khachHang7 = new KhachHang(7,"Nguyen Van F", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
                8);

        arrKhachHang.add(khachHang1);
        arrKhachHang.add(khachHang2);
        arrKhachHang.add(khachHang3);
        arrKhachHang.add(khachHang4);
        arrKhachHang.add(khachHang5);
        arrKhachHang.add(khachHang6);
        arrKhachHang.add(khachHang7);
        KhachHangAdapter khachHangAdapter = new KhachHangAdapter(this,R.layout.listview_man_hinh_cho_layout,arrKhachHang);
        lvKhachHang.setAdapter(khachHangAdapter);

    }
}
