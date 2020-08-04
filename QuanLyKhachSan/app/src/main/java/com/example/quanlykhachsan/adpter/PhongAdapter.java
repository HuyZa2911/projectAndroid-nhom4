package com.example.quanlykhachsan.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlykhachsan.models_data.Phong;
import com.example.quanlykhachsan.R;

import java.util.ArrayList;

public class PhongAdapter extends RecyclerView.Adapter<PhongAdapter.MyViewHolder> {

    private ArrayList<Phong> list;

    public PhongAdapter(ArrayList<Phong> dataRoom) {
        this.list = dataRoom;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtGiaTheoGio;
        TextView txtGiaTheoNgay;
        TextView txtTinhTrang;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtGiaTheoGio = itemView.findViewById(R.id.txtGiaTheoGio);
            txtGiaTheoNgay = itemView.findViewById(R.id.txtGiaTheoNgay);
            txtTinhTrang = itemView.findViewById(R.id.txtTinhTrang);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cardView = (CardView) inflater.inflate(R.layout.item_room, parent, false);
        //CardView cardView = (CardView) inflater.inflate(viewType, parent, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder viewHolder, int position) {
        Phong aCard = list.get(position);
        viewHolder.txtGiaTheoGio.setText(String.valueOf(aCard.getGiaTienTheoGio())+"đ/h");
        viewHolder.txtGiaTheoNgay.setText(String.valueOf(aCard.getGetGiaTienTheoNgay())+"đ/ngày");
        viewHolder.txtTinhTrang.setText(String.valueOf(aCard.getTrangThai()));
    }


    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_room;
    }
}
