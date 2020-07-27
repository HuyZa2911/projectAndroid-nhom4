package com.example.quanlykhachsan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlykhachsan.R;


public class InformationFragment extends Fragment {
    public static Fragment newInstance() {
        Bundle args = new Bundle();
        InformationFragment fragment = new InformationFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information, container, false);
    }
}