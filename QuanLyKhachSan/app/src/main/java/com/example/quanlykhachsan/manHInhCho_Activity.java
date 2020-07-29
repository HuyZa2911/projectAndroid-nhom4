package com.example.quanlykhachsan;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.quanlykhachsan.Data.KhachHang;
import com.example.quanlykhachsan.Data.KhachHangAdapter;


import java.util.ArrayList;

public class manHInhCho_Activity extends AppCompatActivity {
    private ListView lvKhachHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_man_hinh_cho_layout);
        lvKhachHang = (ListView) findViewById(R.id.lvKhachHang);
        ArrayList<KhachHang> arrCustomer = new ArrayList<>();
        KhachHang customer1 = new KhachHang(1 ,"Nguyen Van A", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
                8);
        KhachHang customer2 = new KhachHang(2 ,"Nguyen Van B", "123456", "12/5/2002", "12/8/2019", "so 4 Tu Duc",
                8);
        KhachHang customer3 = new KhachHang(3,"Nguyen Van An", "123456", "12/5/2003", "12/8/2019", "so 4 Thu Duc",
                8);
        KhachHang customer4 = new KhachHang(4,"Nguyen Van Anh", "123456", "12/5/2001", "12/8/2019", "so 4 Thu",
                8);
        KhachHang customer5 = new KhachHang(5,"Nguyen Van D", "123456", "12/5/2002", "12/8/2019", "so 4 Tan Duc",
                8);
        KhachHang customer6 = new KhachHang(6,"Nguyen Van E", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
                8);
        KhachHang customer7 = new KhachHang(7,"Nguyen Van F", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
                8);

        arrCustomer.add(customer1);
        arrCustomer.add(customer2);
        arrCustomer.add(customer3);
        arrCustomer.add(customer4);
        arrCustomer.add(customer5);
        arrCustomer.add(customer6);
        arrCustomer.add(customer7);
        KhachHangAdapter khachHangAdapter = new KhachHangAdapter(this,R.layout.listview_man_hinh_cho_layout, arrCustomer);
        lvKhachHang.setAdapter(khachHangAdapter);

    }
}
