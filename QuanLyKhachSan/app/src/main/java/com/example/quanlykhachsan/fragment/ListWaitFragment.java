package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlykhachsan.adpter.KhachHangAdapter;
import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.models_data.KhachHang;

import java.util.ArrayList;


public class ListWaitFragment extends Fragment {

    private Context context;
    ListView lvKhachHang;
    public static ListWaitFragment newInstance() {
        Bundle args = new Bundle();
        ListWaitFragment fragment = new ListWaitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_list_wait, container,
                false);
        lvKhachHang = rootView.findViewById(R.id.lvKhachHang);

        final ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
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
        KhachHangAdapter khachHangAdapter = new KhachHangAdapter(context,R.layout.fragment_item_list_wait,arrKhachHang);

            lvKhachHang.setAdapter(khachHangAdapter);
            lvKhachHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context,String.valueOf(position),Toast.LENGTH_SHORT).show();
                }
            });
        return rootView;
    }
}