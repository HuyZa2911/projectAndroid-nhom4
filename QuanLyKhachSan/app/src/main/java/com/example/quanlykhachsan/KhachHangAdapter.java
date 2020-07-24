package com.example.quanlykhachsan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

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
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_item_wait, parent, false);
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
        KhachHang customer =  arrCustomer.get(position);

        viewHold.tvIdPhong.setText(String.valueOf(customer.getIdPhong()) );
        viewHold.edtTen.setText(customer.getHoTen());
        viewHold.edtDiaChi.setText(customer.getDiaChi());
        viewHold.edtSDT.setText(customer.getSdt());
        viewHold.edtSoGioThue.setText(String.valueOf(customer.getSoGioThue()));
        viewHold.edtNgayTra.setText((CharSequence) customer.getNgayTra());
        viewHold.edtNgayThue.setText((CharSequence) customer.getNgayThue());
        return convertView;



    }

}
