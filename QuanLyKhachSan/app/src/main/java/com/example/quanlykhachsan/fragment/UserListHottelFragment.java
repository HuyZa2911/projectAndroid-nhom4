package com.example.quanlykhachsan.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.quanlykhachsan.R;
import com.example.quanlykhachsan.TestDialog;
import com.example.quanlykhachsan.adpter.PhongAdapter;
import com.example.quanlykhachsan.adpter.UserListHottelAdapter;
import com.example.quanlykhachsan.models_data.DatPhong;
import com.example.quanlykhachsan.models_data.History;
import com.example.quanlykhachsan.models_data.KhachSan;
import com.example.quanlykhachsan.models_data.Phong;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;


public class UserListHottelFragment extends Fragment {
    RecyclerView rcListRoom;
    Context context;
    LinearLayout selectionBookingDay;
    LinearLayout selectionBookingHours;
    RadioButton radioBookingDay;
    RadioButton radioBookingHours;
    RadioGroup radioGroup;
    Button btnCancel;
    Button btnConfirm;
    EditText edtCheckinDay, edtChekoutDay, edtDayHours, edtTimeIn, edtTimeOut,edtName,edtPhone,edcmnd,totalTimeDay, totalTimeHours;
    TextView nameRoom,tvPriceDay,tvPriceHours;
    ImageView btnClose;
    String idKhachSan,ten,sdt,cmnd,gioTra,gioDat,priceDay,priceHours,idRoom,dayHours,time,nameHottel,diaChiKS;
    int loaiDat,price,totalTime;
    String idChuKS,idUser,tenPhong;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    final ArrayList<Phong> dataRoom = new ArrayList<Phong>();
    public static UserListHottelFragment newInstance(String idKS, String idUser) {
        Bundle args = new Bundle();
        UserListHottelFragment fragment = new UserListHottelFragment();
        args.putString("idKS",idKS);
        args.putString("idUser",idUser);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_room, container, false);
        Bundle bundle = getArguments();
        if (bundle !=null) {
            idChuKS = bundle.getString("idKS");
            idUser = bundle.getString("idUser");
        }
        rcListRoom = view.findViewById(R.id.rcListRoom);
        readData(idChuKS);
        setonClick();
        return view;
    }
    private String id;
    final void readData(final String idKS){

        database.child("khachsan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                KhachSan ks = snapshot.getValue(KhachSan.class);
                if(ks.getIdChuKS().equals(idKS)){
                    id = snapshot.getKey();
                    nameHottel= ks.getTenKS();
                    diaChiKS = ks.getDiaChi();
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

        database.child("Phong").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Phong p = snapshot.getValue(Phong.class);
                String idPhong = snapshot.getKey();
                if (p.getIdKhachSan().equals(id)){
                    dataRoom.add(new Phong(idPhong,p.getIdKhachSan(),p.getNameRoom(),p.getSoGiuong(),p.getLoaiPhong(),p.getTrangThai(),p.getGiaTienTheoGio(),p.getGetGiaTienTheoNgay()));
                }
                LinearLayoutManager layoutManager = new GridLayoutManager(context,2);
                rcListRoom.setLayoutManager(layoutManager);
                UserListHottelAdapter listRoom = new UserListHottelAdapter(dataRoom);
                rcListRoom.setAdapter(listRoom);
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
    }
    private void setonClick(){
        rcListRoom.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rcListRoom ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        if(dataRoom.get(position).getTrangThai()==0){

                            DialogBooking();
                            nameRoom.setText(dataRoom.get(position).getNameRoom());

                            DialogBooking();
                            priceDay = String.valueOf(dataRoom.get(position).getGetGiaTienTheoNgay());
                            priceHours =String.valueOf(dataRoom.get(position).getGiaTienTheoGio());
                            idKhachSan= dataRoom.get(position).getIdKhachSan();
                            idRoom = dataRoom.get(position).getIdPhong();
                            nameRoom.setText(dataRoom.get(position).getNameRoom());
                            tvPriceDay.setText(priceDay);
                            tvPriceHours.setText(priceHours);
                            tenPhong = dataRoom.get(position).getNameRoom();
                        }
                        else {
                           Toast.makeText(context,"Phòng này đã được thuê",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }
    private void DialogBooking() {
        final Dialog dialog = new Dialog(context, R.style.MyAlertDialogTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_booking);
        radioBookingDay = dialog.findViewById(R.id.radioBookingDay);
        radioBookingHours = dialog.findViewById(R.id.radioBookingHours);
        selectionBookingDay = dialog.findViewById(R.id.selectionBookingDay);
        selectionBookingHours = dialog.findViewById(R.id.selectionBookingHours);
        edtCheckinDay = dialog.findViewById(R.id.edtCheckinDay);
        edtChekoutDay = dialog.findViewById(R.id.edtCheckOutDay);
        edtDayHours = dialog.findViewById(R.id.edtDayHours);
        radioGroup = dialog.findViewById(R.id.rdgButton);
        edtTimeIn = dialog.findViewById(R.id.edtTimeIn);
        edtTimeOut = dialog.findViewById(R.id.edtTimeOut);
        nameRoom = dialog.findViewById(R.id.nameRoom);
        edtName = dialog.findViewById(R.id.edtName);
        edtPhone = dialog.findViewById(R.id.edtPhone);
        edcmnd = dialog.findViewById(R.id.cmnd);
        totalTimeHours = dialog.findViewById(R.id.totalTimeHours);
        totalTimeDay = dialog.findViewById(R.id.totalTimeDay);
        tvPriceDay = dialog.findViewById(R.id.priceDay);
        tvPriceHours = dialog.findViewById(R.id.priceHours);
        ClickButton(dialog);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//   TODO: add admin booking rooom

                ten = edtName.getText().toString();
                sdt = edtPhone.getText().toString();
                cmnd = edcmnd.getText().toString();
                if (radioBookingDay.isChecked()){
                    price = Integer.parseInt(priceDay);
                    gioDat = edtCheckinDay.getText().toString();
                    gioTra = edtChekoutDay.getText().toString();
                    totalTime = Integer.parseInt(totalTimeDay.getText().toString());
                    dayHours = "null";
                    loaiDat = 1;
                    time = gioDat + " - " + gioTra;
                }
                if(radioBookingHours.isChecked()){
                    price = Integer.parseInt(priceHours);
                    gioDat = edtTimeIn.getText().toString();
                    gioTra = edtTimeOut.getText().toString();
                    totalTime = Integer.parseInt(totalTimeHours.getText().toString());
                    dayHours = edtDayHours.getText().toString();
                    loaiDat =0;
                    time = gioDat+" - "+gioTra+" "+dayHours;
                }
                database.child("BookingRoom").push().setValue(new DatPhong(idUser,idKhachSan,idRoom,null,gioDat,gioTra,ten,sdt,cmnd,dayHours,loaiDat,price,0,2,totalTime,tenPhong));
                database.child("History").push().setValue(new History(idUser,time,nameHottel,diaChiKS,String.valueOf(price),1));
                database.child("Phong").child(idRoom).child("trangThai").setValue(2);
//                database.child("BookingRoom").push().setValue(new DatPhong("asd","asd","asd","asd","sad","asd", "asd","asd","sad",2,3,4,1,2));

                dialog.dismiss();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        selectionBookingHours.setVisibility(View.GONE);
                        selectionBookingDay.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        selectionBookingDay.setVisibility(View.GONE);
                        selectionBookingHours.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        edtCheckinDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeclectDay(edtCheckinDay);
            }
        });
        edtChekoutDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeclectDay(edtChekoutDay);
            }
        });
        edtDayHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeclectDay(edtDayHours);
            }
        });
        edtTimeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTime(edtTimeIn);
            }
        });
        edtTimeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTime(edtTimeOut);
            }
        });

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        dialog.show();
    }
    private void ClickButton(final Dialog dialog) {
        btnClose = dialog.findViewById(R.id.btnClose);
        btnConfirm = dialog.findViewById(R.id.btnConfirm);
        btnCancel = dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    private void SeclectDay(final EditText dateInput) {
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        context,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                dateInput.setText(date);
            }
        };
    }


    private void SelectTime(final EditText timeInput) {
        timeInput.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO: Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeInput.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }
}