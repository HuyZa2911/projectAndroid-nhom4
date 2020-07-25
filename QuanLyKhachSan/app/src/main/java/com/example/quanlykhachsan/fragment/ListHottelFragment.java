package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.adpter.ListHottelAdapter;
import com.example.quanlykhachsan.models_data.KhachSan;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 */
public class ItemhomeUserFragment extends Fragment {
    ListView lvListHottel;
    Context context;
    public static ItemhomeUserFragment newInstance() {
        Bundle args = new Bundle();
        ItemhomeUserFragment fragment = new ItemhomeUserFragment();
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
        ArrayList<KhachSan> arrKhachsan =new ArrayList<KhachSan>();
        KhachSan ks1 = new KhachSan(1,"Khách sạn 1","54 Võ văn Ngân Q.Thủ Đức",1);
        KhachSan ks2 = new KhachSan(2,"Khách sạn 2","54 Võ văn Ngân Q.Thủ Đức",1);
        KhachSan ks3 = new KhachSan(3,"Khách sạn 3","54 Võ văn Ngân Q.Thủ Đức",1);

        arrKhachsan.add(ks1);
        arrKhachsan.add(ks2);
        arrKhachsan.add(ks3);

        ListHottelAdapter hottelAdapter =  new ListHottelAdapter(context,R.layout.fragment_item_hottel,arrKhachsan);
        lvListHottel.setAdapter(hottelAdapter);
        return view;
    }
}