package com.example.quanlykhachsan.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.models_data.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangAdapter extends ArrayAdapter<KhachHang> {
    private Context context;
    private int resource;
    private List<KhachHang> arrCustomer;
    public KhachHangAdapter(Context context, int resource, ArrayList<KhachHang> arrCustomer) {
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
        KhachHang customer =  arrCustomer.get(position);

        viewHold.lblPhong.setText(String.valueOf(customer.getIdPhong()) );
        viewHold.lblTen.setText(customer.getHoTen());
        viewHold.lblSdt.setText(customer.getSdt());
        viewHold.lblDiaChi.setText(customer.getDiaChi());
//        viewHold.lblLoaiThue.setText(customer.ge());
        viewHold.lblThoiGianThue.setText(String.valueOf(customer.getSoGioThue()));
        viewHold.lblNgayTra.setText((CharSequence) customer.getNgayTra());
        viewHold.lblNgayThue.setText((CharSequence) customer.getNgayThue());
        return convertView;



    }

}
