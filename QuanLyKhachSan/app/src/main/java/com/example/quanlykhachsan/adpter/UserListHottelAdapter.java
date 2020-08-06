package com.example.quanlykhachsan.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlykhachsan.models_data.Phong;
import com.example.quanlykhachsan.R;

import java.util.ArrayList;

public class UserListHottelAdapter extends RecyclerView.Adapter<UserListHottelAdapter.MyViewHolder> {

    private ArrayList<Phong> list;
    private Context context;
    public UserListHottelAdapter(ArrayList<Phong> dataRoom) {
        this.list = dataRoom;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtGiaTheoGio;
        TextView txtGiaTheoNgay;
        TextView txtTinhTrang;
        TextView txtnameRoom;
        LinearLayout background_item_rom;

        public MyViewHolder(View itemView) {
            super(itemView);
            background_item_rom= itemView.findViewById(R.id.background_item_rom);
            txtGiaTheoGio = itemView.findViewById(R.id.txtGiaTheoGio);
            txtGiaTheoNgay = itemView.findViewById(R.id.txtGiaTheoNgay);
            txtTinhTrang = itemView.findViewById(R.id.txtTinhTrang);
            txtnameRoom = itemView.findViewById(R.id.txtnameRoom);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        context = parent.getContext();
        LinearLayout cardView = (LinearLayout) inflater.inflate(R.layout.item_room, parent, false);
        //CardView cardView = (CardView) inflater.inflate(viewType, parent, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        Phong aCard = list.get(position);
        viewHolder.txtnameRoom.setText(aCard.getNameRoom());
        viewHolder.txtGiaTheoGio.setText(aCard.getGiaTienTheoGio()+"đ/h");
        viewHolder.txtGiaTheoNgay.setText(aCard.getGetGiaTienTheoNgay()+"đ/ngày");
        if (aCard.getTrangThai() == 0){
            viewHolder.txtTinhTrang.setText("Phòng trống");
        }else{
            viewHolder.txtTinhTrang.setTextColor(ContextCompat.getColor(context,R.color.text_red));
            viewHolder.background_item_rom.setBackground(ContextCompat.getDrawable(context,R.drawable.layout_item_romm));
            viewHolder.txtTinhTrang.setText("Đang thuê");
        }
    }


    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_room;
    }
}
