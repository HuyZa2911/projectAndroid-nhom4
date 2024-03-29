package com.example.quanlykhachsan.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.models_data.KhachSan;

import java.util.List;

public class ListHottelAdapter extends ArrayAdapter<KhachSan> {
    private Context context;
    private int resource;
    private List<KhachSan> arrCustomer;

    public ListHottelAdapter( Context context, int resource,  List<KhachSan> arrCustomer) {
        super(context, resource, arrCustomer);
        this.context = context;
        this.resource = resource;
        this.arrCustomer = arrCustomer;
    }

    private class ViewHover {
        TextView lblNameHottel;
        TextView lblPhoneHottel;
        TextView lblAddress;
        RatingBar ratingBar;
        TextView lblPriceBookingDay;
        TextView lblPriceBookingHours;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        ViewHover viewHold;
        convertView = LayoutInflater.from(context).inflate(R.layout.fragment_item_hottel, parent, false);
        viewHold = new ViewHover();
        viewHold.lblNameHottel = convertView.findViewById(R.id.lblNameHottel);
        viewHold.lblPhoneHottel = convertView.findViewById(R.id.lblPhoneHottel);
        viewHold.lblAddress = convertView.findViewById(R.id.lblAddress);
        viewHold.ratingBar = convertView.findViewById(R.id.ratingBar);
        viewHold.lblPriceBookingDay = convertView.findViewById(R.id.lblPriceBookingDay);
        viewHold.lblPriceBookingHours = convertView.findViewById(R.id.lblPriceBookingHours);

        KhachSan dataHottel = arrCustomer.get(position);

        viewHold.lblNameHottel.setText(dataHottel.getTenKS());
        viewHold.lblPhoneHottel.setText(String.valueOf(dataHottel.getPhone()));
        viewHold.lblAddress.setText(dataHottel.getDiaChi());
        viewHold.ratingBar.setRating(dataHottel.getLoaiKS());
        viewHold.lblPriceBookingDay.setText(dataHottel.getGiaTheoNgay());
        viewHold.lblPriceBookingHours.setText(dataHottel.getGiaTheoGio());
        return convertView;
    }
}
