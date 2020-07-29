package com.example.quanlykhachsan.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.models_data.KhachSan;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeAdminFragment extends Fragment {
    String idChuKS;
    EditText nameHottel,phoneNumber,diaChi,numberRoom;
    public static Fragment newInstance(String idAcount) {
        Bundle args = new Bundle();
        HomeAdminFragment fragment = new HomeAdminFragment();
        args.putString("idAcount",idAcount);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.control_hotel_background, container, false);
        nameHottel = view.findViewById(R.id.nameHottel);
        phoneNumber = view.findViewById(R.id.phoneNumber);
        numberRoom = view.findViewById(R.id.numberRoom);
        diaChi = view.findViewById(R.id.diaChi);
        Bundle bundle = getArguments();
        if (bundle !=null){
            idChuKS = bundle.getString("idAcount");
        }
        setData();
        return view;
    }
    private void setData(){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("khachsan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot,String previousChildName) {
                KhachSan ks = snapshot.getValue(KhachSan.class);
                if(idChuKS.equals(ks.getIdChuKS())){
                    nameHottel.setText(ks.getTenKS());
                    phoneNumber.setText(String.valueOf(ks.getPhone()));
                    numberRoom.setText(String.valueOf(ks.getNuberRoom()));
                    diaChi.setText(ks.getDiaChi());
                }
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
}