package com.example.quanlykhachsan.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlykhachsan.models_data.CardViewModel;
import com.example.quanlykhachsan.R;
import java.util.Vector;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Vector<CardViewModel> list;

    public MyAdapter(Vector<CardViewModel> list) {
        this.list = list;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imvImageHotel;
        TextView txtGiaTheoGio;
        TextView txtGiaTheoNgay;
        TextView txtTinhTrang;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imvImageHotel = itemView.findViewById(R.id.imvImageHotel);
            txtGiaTheoGio = itemView.findViewById(R.id.txtGiaTheoGio);
            txtGiaTheoNgay = itemView.findViewById(R.id.txtGiaTheoNgay);
            txtTinhTrang = itemView.findViewById(R.id.txtTinhTrang);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cardView = (CardView) inflater.inflate(R.layout.item_room, parent, false);
        //CardView cardView = (CardView) inflater.inflate(viewType, parent, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        CardViewModel aCard = list.get(position);
        viewHolder.imvImageHotel.setImageResource(aCard.getGetImvImageHotel());
        viewHolder.txtGiaTheoGio.setText(aCard.getGiaTheoGio());
        viewHolder.txtGiaTheoNgay.setText(aCard.getGiaTheoNgay());
        viewHolder.txtTinhTrang.setText(aCard.getTinhTrang());
    }


    public int getItemCount() {
        return list.size();
    }
}
