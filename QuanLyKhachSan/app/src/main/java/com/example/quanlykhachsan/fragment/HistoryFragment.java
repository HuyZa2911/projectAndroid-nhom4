package com.example.quanlykhachsan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.adpter.HistoryAdapter;
import com.example.quanlykhachsan.models_data.History;
import com.example.quanlykhachsan.models_data.KhachSan;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    ListView lvHistory;
    Context context;
    final ArrayList<History> arrayList =new ArrayList<History>();

    public static HistoryFragment newInstance() {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
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
        arrayList.add(new History("as","asd","sad","1000",0));
        arrayList.add(new History("as","asd","sad","1000",1));
        HistoryAdapter historyAdapter = new HistoryAdapter(context,R.layout.fragment_history,arrayList);
        lvHistory.setAdapter(historyAdapter);
        return view;
    }
}