package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.adpter.ListHottelAdapter;
import com.example.quanlykhachsan.models_data.KhachSan;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 */
public class ListHottelFragment extends Fragment {
    ListView lvListHottel;
    Context context;
    final ArrayList<KhachSan> arrKhachsan =new ArrayList<KhachSan>();
    public static ListHottelFragment newInstance() {
        Bundle args = new Bundle();
        ListHottelFragment fragment = new ListHottelFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_hottel, container, false);
        lvListHottel = view.findViewById(R.id.lvListHottel);
//        KhachSan ks1 = new KhachSan("1","Khách sạn 1","54 Võ văn Ngân Q.Thủ Đức",1,1,1);
//        KhachSan ks2 = new KhachSan("2","Khách sạn 2","54 Võ văn Ngân Q.Thủ Đức",1,2,2);
//        KhachSan ks3 = new KhachSan("3","Khách sạn 3","54 Võ văn Ngân Q.Thủ Đức",1,3,3);
//
//        arrKhachsan.add(ks1);
//        arrKhachsan.add(ks2);
//        arrKhachsan.add(ks3);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("khachsan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                KhachSan ks = snapshot.getValue(KhachSan.class);
                arrKhachsan.add(new KhachSan(ks.getIdChuKS(),ks.getTenKS(),ks.getDiaChi(),ks.getLoaiKS(),ks.getPhone(),ks.getNuberRoom()));
                ListHottelAdapter hottelAdapter =  new ListHottelAdapter(context,R.layout.fragment_item_hottel,arrKhachsan);
                lvListHottel.setAdapter(hottelAdapter);
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
        return view;
    }
}