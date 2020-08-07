package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.RoomUser;
import com.example.quanlykhachsan.adpter.ListHottelAdapter;
import com.example.quanlykhachsan.models_data.KhachSan;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ListHottelFragment extends Fragment {
    ListView lvListHottel;
    Context context;
    String idUser;
    final ArrayList<KhachSan> arrKhachsan =new ArrayList<KhachSan>();
    public static ListHottelFragment newInstance(String idAcount) {
        Bundle args = new Bundle();
        ListHottelFragment fragment = new ListHottelFragment();
        args.putString("isUserBooking",idAcount);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_hottel, container, false);
        lvListHottel = view.findViewById(R.id.lvListHottel);

        Bundle bundle = getArguments();
        if (bundle !=null){
            idUser = bundle.getString("isUserBooking");
        }

        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("khachsan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                KhachSan ks = snapshot.getValue(KhachSan.class);
                arrKhachsan.add(new KhachSan(ks.getIdChuKS(),ks.getTenKS(),ks.getDiaChi(),ks.getGiaTheoNgay(),ks.getGiaTheoGio(),ks.getNuberRoom(),ks.getPhone(),ks.getLoaiKS()));
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
        lvListHottel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, RoomUser.class);
                intent.putExtra("idKhachSan",arrKhachsan.get(position).getIdChuKS());
                intent.putExtra("idUserBooking",idUser);
                startActivity(intent);
            }
        });
        return view;
    }
}