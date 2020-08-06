package com.example.quanlykhachsan.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlykhachsan.adpter.KhachHangAdapter;
import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.models_data.DatPhong;
import com.example.quanlykhachsan.models_data.History;
import com.example.quanlykhachsan.models_data.KhachHang;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ListWaitFragment extends Fragment {

    private Context context;
    ListView lvKhachHang;
    String idKS, idUser,idRoom,idHistory,idBooking;

    TextView tvMaSoPhong;
    EditText edName,edSoDienThoai,edCMND,edThueTheo,edSo,tvNgayDatPhong,tvNgayTraPhong,edTienDatCoc,edNgay;
    ImageView btnClose;
    Button btnCancel,btnConfirm;
    LinearLayout lvBookingHours;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<DatPhong> arrKhachHang = new ArrayList<DatPhong>();
    ArrayList<String> arrHistory = new ArrayList<String>();
    public static ListWaitFragment newInstance(String idKS) {
        Bundle args = new Bundle();
        ListWaitFragment fragment = new ListWaitFragment();
        args.putString("idKhachSanWait",idKS);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_list_wait, container,
                false);
        lvKhachHang = rootView.findViewById(R.id.lvKhachHang);

        Bundle bundle = getArguments();
        if (bundle !=null) {
            idKS = bundle.getString("idKhachSanWait");
        }

//        KhachHang khachHang1 = new KhachHang(1 ,"Nguyen Van A", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
//                8);
//        KhachHang khachHang2 = new KhachHang(2 ,"Nguyen Van B", "123456", "12/5/2002", "12/8/2019", "so 4 Tu Duc",
//                8);
//        KhachHang khachHang3 = new KhachHang(3,"Nguyen Van An", "123456", "12/5/2003", "12/8/2019", "so 4 Thu Duc",
//                8);
//        KhachHang khachHang4 = new KhachHang(4,"Nguyen Van Anh", "123456", "12/5/2001", "12/8/2019", "so 4 Thu",
//                8);
//        KhachHang khachHang5 = new KhachHang(5,"Nguyen Van D", "123456", "12/5/2002", "12/8/2019", "so 4 Tan Duc",
//                8);
//        KhachHang khachHang6 = new KhachHang(6,"Nguyen Van E", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
//                8);
//        KhachHang khachHang7 = new KhachHang(7,"Nguyen Van F", "123456", "12/5/2002", "12/8/2019", "so 4 Thu Duc",
//                8);
//
//        arrKhachHang.add(khachHang1);
//        arrKhachHang.add(khachHang2);
//        arrKhachHang.add(khachHang3);
//        arrKhachHang.add(khachHang4);
//        arrKhachHang.add(khachHang5);
//        arrKhachHang.add(khachHang6);
//        arrKhachHang.add(khachHang7);

        database.child("BookingRoom").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                DatPhong dt = snapshot.getValue(DatPhong.class);
                if (dt.getIdKhachSan().equals(idKS) && dt.getTrangThai() == 2){
                    arrHistory.add(snapshot.getKey());
                    arrKhachHang.add(new DatPhong(dt.getIdUser(),dt.getIdKhachSan(),dt.getIdPhong(),dt.getIdHistory(),dt.getGioThue(),dt.getGioTra(),dt.getTen(),dt.getSdt(),dt.getCmnd(),dt.getDayHours(),dt.getLoaiDat(),dt.getdTongTien(),dt.getdTienCoc(),dt.getTrangThai(),dt.getThoiGianThue()));
                }
                KhachHangAdapter khachHangAdapter = new KhachHangAdapter(context,R.layout.fragment_item_list_wait,arrKhachHang);

                lvKhachHang.setAdapter(khachHangAdapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        lvKhachHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialog();

                tvMaSoPhong.setText(arrKhachHang.get(position).getIdKhachSan());
                edName.setText(arrKhachHang.get(position).getTen());
                edCMND.setText(arrKhachHang.get(position).getCmnd());
                edSo.setText(String.valueOf(arrKhachHang.get(position).getThoiGianThue()));
                tvNgayDatPhong.setText(arrKhachHang.get(position).getGioThue());
                tvNgayTraPhong.setText(arrKhachHang.get(position).getGioTra());
                if (arrKhachHang.get(position).getLoaiDat() ==0){
                    lvBookingHours.setVisibility(View.VISIBLE);
                    edNgay.setText(arrKhachHang.get(position).getDayHours());
                }
                idUser = arrKhachHang.get(position).getIdUser();
                idRoom = arrKhachHang.get(position).getIdPhong();
                idBooking = arrHistory.get(position);
            }
        });
        return rootView;
    }
    private void  showDialog(){
        final Dialog dialog = new Dialog(context, R.style.MyAlertDialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_display);


        tvMaSoPhong = dialog.findViewById(R.id.tvMaSoPhong);
        edName = dialog.findViewById(R.id.edName);
        edSoDienThoai= dialog.findViewById(R.id.edSoDienThoai);
        edThueTheo = dialog.findViewById(R.id.edThueTheo);
        edCMND = dialog.findViewById(R.id.edCMND);
        edSo = dialog.findViewById(R.id.edSo);
        tvNgayDatPhong = dialog.findViewById(R.id.tvNgayDatPhong);
        tvNgayTraPhong = dialog.findViewById(R.id.tvNgayTraPhong);
        edTienDatCoc = dialog.findViewById(R.id.edTienDatCoc);
        btnClose = dialog.findViewById(R.id.btnClose);
        btnCancel = dialog.findViewById(R.id.btnCancel);
        btnConfirm = dialog.findViewById(R.id.btnConfirm);
        lvBookingHours = dialog.findViewById(R.id.lvBookingHours);
        edNgay = dialog.findViewById(R.id.edNgay);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setMessage("Xác nhận thành công!")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface d, int which) {
                                database.child("BookingRoom").child(idBooking).child("trangThai").setValue(1);
                                database.child("Phong").child(idRoom).child("trangThai").setValue(1);
                                database.child("History").addChildEventListener(new ChildEventListener() {
                                    @Override
                                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                        History hs = snapshot.getValue(History.class);
                                        if(hs.getIdUser().equals(idUser) && hs.getStatus()== 1){
                                            database.child("History").child(snapshot.getKey()).child("status").setValue(0);
                                        }
                                    }

                                    @Override
                                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                                    }

                                    @Override
                                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                                    }

                                    @Override
                                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setMessage("Bạn có chắc chắn hủy không?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface d, int which) {
                                database.child("BookingRoom").child(idBooking).child("trangThai").setValue(3);
                                database.child("Phong").child(idRoom).child("trangThai").setValue(0);
                                database.child("History").addChildEventListener(new ChildEventListener() {
                                    @Override
                                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                        History hs = snapshot.getValue(History.class);
                                        if(hs.getIdUser().equals(idUser) && hs.getStatus()== 1){
                                            database.child("History").child(snapshot.getKey()).child("status").setValue(1);
                                        }
                                    }

                                    @Override
                                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                                    }

                                    @Override
                                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                                    }

                                    @Override
                                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .show();
            }
        });

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        dialog.show();
    }
}