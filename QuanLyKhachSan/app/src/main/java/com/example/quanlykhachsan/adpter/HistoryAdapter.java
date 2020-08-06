package com.example.quanlykhachsan.adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.models_data.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<History> {
    private Context context;
    private int resource;
    private List<History> arrCustomer;

    public HistoryAdapter(Context context, int resource, ArrayList<History> arrCustomer) {
        super(context, resource, arrCustomer);
        this.context = context;
        this.resource = resource;
        this.arrCustomer = arrCustomer;
    }

    public class ViewHolder {
        private TextView lblTime, lblNameHottel, tvDiaChiUp, lblStatus, lblPrice;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHold;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_history, parent, false);
            viewHold = new ViewHolder();
            viewHold.lblTime = convertView.findViewById(R.id.lblTime);
            viewHold.lblNameHottel = convertView.findViewById(R.id.lblNameHottel);
            viewHold.tvDiaChiUp = convertView.findViewById(R.id.tvDiaChiUp);
            viewHold.lblStatus = convertView.findViewById(R.id.lblStatus);
            viewHold.lblPrice = convertView.findViewById(R.id.lblPrice);

            convertView.setTag(viewHold);

        } else {
            viewHold = (ViewHolder) convertView.getTag();
        }
        History history = arrCustomer.get(position);
        viewHold.lblTime.setText(history.getTime());
        viewHold.lblNameHottel.setText(history.getNameHottel());
        viewHold.tvDiaChiUp.setText(history.getDiaChi());
        viewHold.lblPrice.setText(history.getPrice());
        if (history.getStatus() == 0) {
            viewHold.lblStatus.setTextColor(ContextCompat.getColor(context,R.color.textFinish));
            viewHold.lblStatus.setText("HOÀN THÀNH");
        }
        if (history.getStatus() == 1){
            viewHold.lblStatus.setTextColor(ContextCompat.getColor(context,R.color.colorBlue));
            viewHold.lblStatus.setText("CHỜ DUYỆT");
        }
        if (history.getStatus() == 2) {
            viewHold.lblStatus.setTextColor(ContextCompat.getColor(context,R.color.textCanel));
            viewHold.lblStatus.setText("HỦY");
        }

        return convertView;


    }

}
