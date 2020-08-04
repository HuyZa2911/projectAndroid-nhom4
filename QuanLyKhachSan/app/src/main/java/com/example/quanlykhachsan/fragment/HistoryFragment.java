package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.adpter.HistoryAdapter;
import com.example.quanlykhachsan.models_data.History;
import com.example.quanlykhachsan.models_data.KhachSan;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    ListView lvHistory;
    Context context;
    String idUser;
    final ArrayList<History> arrayList =new ArrayList<History>();

    public static HistoryFragment newInstance(String idAcount) {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        args.putString("idAcount",idAcount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_list, container, false);
        lvHistory = view.findViewById(R.id.lvListHistory);

        Bundle bundle = getArguments();
        if (bundle !=null){
            idUser = bundle.getString("idAcount");
        }
        readData(idUser);

        return view;
    }
    private void readData(final String idAcount){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("History").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                History hs = snapshot.getValue(History.class);
                if (hs.getIdUser().equals(idAcount)){
                    arrayList.add(new History(hs.getIdUser(),hs.getTime(),hs.getNameHottel(),hs.getDiaChi(),hs.getPrice(),hs.getStatus()));
                }
                HistoryAdapter historyAdapter = new HistoryAdapter(context,R.layout.fragment_history,arrayList);
                lvHistory.setAdapter(historyAdapter);
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