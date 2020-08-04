package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.adpter.PhongAdapter;
import com.example.quanlykhachsan.models_data.Phong;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ListRoomFragment extends Fragment {
    RecyclerView rcListRoom;
    Context context;
    String idChuKS;
    final ArrayList<Phong> dataRoom = new ArrayList<Phong>();
    public static ListRoomFragment newInstance(String idKS) {
        Bundle args = new Bundle();
        ListRoomFragment fragment = new ListRoomFragment();
        args.putString("idKS",idKS);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_room, container, false);
        Bundle bundle = getArguments();
        if (bundle !=null) {
            idChuKS = bundle.getString("idKS");
        }
        rcListRoom = view.findViewById(R.id.rcListRoom);
        readData(idChuKS);
        setonClick();
        return view;
    }

    final void readData(final String idKS){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("Phong").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Phong p = snapshot.getValue(Phong.class);
                String idPhong = snapshot.getKey();
                if (p.getIdKhachSan().equals(idKS)){
                    dataRoom.add(new Phong(idPhong,p.getIdKhachSan(),p.getSoGiuong(),p.getLoaiPhong(),p.getTrangThai(),p.getGiaTienTheoGio(),p.getGetGiaTienTheoNgay()));
                }
                LinearLayoutManager layoutManager = new GridLayoutManager(context,2);
                rcListRoom.setLayoutManager(layoutManager);
                PhongAdapter listRoom = new PhongAdapter(dataRoom);
                rcListRoom.setAdapter(listRoom);
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
    }

    private void setonClick(){
        rcListRoom.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rcListRoom ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Toast.makeText(context,String.valueOf(position),Toast.LENGTH_SHORT).show();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }
}