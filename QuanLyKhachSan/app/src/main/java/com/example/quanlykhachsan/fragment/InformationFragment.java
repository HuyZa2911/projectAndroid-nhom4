package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quanlykhachsan.LayoutRegistration;
import com.example.quanlykhachsan.LoginLayout;
import com.example.quanlykhachsan.R;


public class InformationFragment extends Fragment {
    TextView name,phone,email,lblLogout;
    Intent intent;
    Context context;
    public static Fragment newInstance(String name,String phone, String email) {
        Bundle args = new Bundle();
        InformationFragment fragment = new InformationFragment();
        args.putString("name",name);
        args.putString("phone",phone);
        args.putString("email",email);
        fragment.setArguments(args);
        return  fragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        email= view.findViewById(R.id.email);
        lblLogout= view.findViewById(R.id.lblLogout);
        setTex();
        setLblLogout();
        return view;
    }
    private void setTex(){
        Bundle bundle = getArguments();
        name.setText(bundle.getString("name"));
        phone.setText(bundle.getString("phone"));
        email.setText(bundle.getString("email"));
    }
    private void setLblLogout(){
        lblLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, LoginLayout.class);
                startActivity(intent);
            }
        });
    }
}