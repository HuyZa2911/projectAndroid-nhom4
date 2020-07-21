package com.example.quanlykhachsan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.quanlykhachsan.Data.KhachHang;

public class KhachHangAdapter extends ArrayAdapter<KhachHang> {
    private Context context;
    private int resource;
    private List<KhachHang> arrKhachHang;
    public KhachHangAdapter(Context context, int resource, ArrayList<KhachHang> arrKhachHang) {
        super(context, resource, arrKhachHang);
        this.context = context;
        this.resource = resource;
        this.arrKhachHang = arrKhachHang;
    }
    public class ViewHolder{
        private EditText edtTen;
        private TextView tvIdPhong;
        private EditText edtDiaChi;
        private EditText edtNgayTra;
        private EditText edtNgayThue;
        private  EditText edtSDT;
        private EditText edtSoGioThue;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHold;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.man_hinh_cho_layout, parent, false);
            viewHold = new ViewHolder();
            viewHold.tvIdPhong = (TextView) convertView.findViewById(R.id.tvIdPhong);
            viewHold.edtTen = (EditText) convertView.findViewById(R.id.edtTen);
            viewHold.edtDiaChi = (EditText) convertView.findViewById(R.id.edtDiaChi);
            viewHold.edtSDT = (EditText) convertView.findViewById(R.id.edtSDT);
            viewHold.edtNgayThue = (EditText) convertView.findViewById(R.id.edtNgayThue);
            viewHold.edtNgayTra = (EditText) convertView.findViewById(R.id.edtNgayTra);
            viewHold.edtSoGioThue = (EditText) convertView.findViewById(R.id.edtSoGioThue);
            convertView.setTag(viewHold);

        }else {
            viewHold = (ViewHolder) convertView.getTag();
        }
        KhachHang khachHang =  arrKhachHang.get(position);

        viewHold.tvIdPhong.setText(String.valueOf(khachHang.getIdPhong()) );
        viewHold.edtTen.setText(khachHang.getHoTen());
        viewHold.edtDiaChi.setText(khachHang.getDiaChi());
        viewHold.edtSDT.setText(khachHang.getSdt());
        viewHold.edtSoGioThue.setText(String.valueOf(khachHang.getSoGioThue()));
        viewHold.edtNgayTra.setText((CharSequence) khachHang.getNgayTra());
        viewHold.edtNgayThue.setText((CharSequence) khachHang.getNgayThue());
        return convertView;



    }

}
