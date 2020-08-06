package com.example.quanlykhachsan.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.models_data.DatPhong;
import com.example.quanlykhachsan.models_data.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangAdapter extends ArrayAdapter<DatPhong> {
    private Context context;
    private int resource;
    private List<DatPhong> arrCustomer;
    public KhachHangAdapter(Context context, int resource, ArrayList<DatPhong> arrCustomer) {
        super(context, resource, arrCustomer);
        this.context = context;
        this.resource = resource;
        this.arrCustomer = arrCustomer;
    }
    public class ViewHolder{
        private TextView lblTen,lblPhong,lblDiaChi,lblNgayTra,lblNgayThue,lblSdt,lblThoiGianThue,lblLoaiThue;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHold;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_item_wait, parent, false);
            viewHold = new ViewHolder();

            viewHold.lblPhong = (TextView) convertView.findViewById(R.id.idPhong);
            viewHold.lblTen = (TextView) convertView.findViewById(R.id.lblName);
            viewHold.lblSdt = (TextView) convertView.findViewById(R.id.lblPhone);
            viewHold.lblDiaChi = (TextView) convertView.findViewById(R.id.lblDiachi);
            viewHold.lblLoaiThue = (TextView) convertView.findViewById(R.id.lblLoaiThue);
            viewHold.lblNgayThue = (TextView) convertView.findViewById(R.id.lblNgayThue);
            viewHold.lblNgayTra = (TextView) convertView.findViewById(R.id.lblNgayTra);
            viewHold.lblThoiGianThue = (TextView) convertView.findViewById(R.id.lblThoiGianThue);
            convertView.setTag(viewHold);

        }else {
            viewHold = (ViewHolder) convertView.getTag();
        }
        DatPhong customer =  arrCustomer.get(position);


        viewHold.lblPhong.setText(String.valueOf(customer.getIdPhong()) );
        viewHold.lblTen.setText(customer.getTen());
        viewHold.lblSdt.setText(customer.getSdt());
        viewHold.lblDiaChi.setText("Dai chi");
//        viewHold.lblLoaiThue.setText(customer.ge());
        viewHold.lblThoiGianThue.setText(String.valueOf(customer.getThoiGianThue()));
        viewHold.lblNgayTra.setText(customer.getGioTra());
        viewHold.lblNgayThue.setText(customer.getGioThue());
        return convertView;



    }

}
