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
import com.example.quanlykhachsan.adpter.PhongAdapter;
import com.example.quanlykhachsan.models_data.DatPhong;
import com.example.quanlykhachsan.models_data.Phong;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;


public class ListRoomFragment extends Fragment {
    RecyclerView rcListRoom;
    Context context;
    String idChuKS;
    LinearLayout selectionBookingDay;
    LinearLayout selectionBookingHours;
    RadioButton radioBookingDay;
    RadioButton radioBookingHours;
    RadioGroup radioGroup;
    Button btnCancel;
    Button btnConfirm;
    EditText edtCheckinDay, edtChekoutDay, edtDayHours, edtTimeIn, edtTimeOut,edtName,edtPhone,edcmnd,totalTimeDay, totalTimeHours;
    TextView edtPriceDay,edtPriceHours,edtPriceTotal,edtTienCoc,edtPriceRoom;
    TextView nameRoom,tvPriceDay,tvPriceHours;
    ImageView btnClose;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    String idKhachSan,ten,sdt,cmnd,gioTra,gioDat,priceDay,priceHours,idRoom,dayHours,idBooking,tenPhong;
    int loaiDat,price,totalTime;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    final ArrayList<Phong> dataRoom = new ArrayList<Phong>();
    public static ListRoomFragment newInstance(String idKS) {
        Bundle args = new Bundle();
        ListRoomFragment fragment = new ListRoomFragment();
        args.putString("idKS",idKS);
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
        }
        rcListRoom = view.findViewById(R.id.rcListRoom);
        readData(idChuKS);
        setonClick();
        return view;
    }

    final void readData(final String idKS){
        database.child("Phong").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Phong p = snapshot.getValue(Phong.class);
                String idPhong = snapshot.getKey();
                if (p.getIdKhachSan().equals(idKS)){
                    dataRoom.add(new Phong(idPhong,p.getIdKhachSan(),p.getNameRoom(),p.getSoGiuong(),p.getLoaiPhong(),p.getTrangThai(),p.getGiaTienTheoGio(),p.getGetGiaTienTheoNgay()));
                }
                LinearLayoutManager layoutManager = new GridLayoutManager(context,2);
                rcListRoom.setLayoutManager(layoutManager);
                PhongAdapter listRoom = new PhongAdapter(dataRoom);
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
                    @Override public void onItemClick(View view, final int position) {
                        if(dataRoom.get(position).getTrangThai()==0){

                            DialogBooking();
                            priceDay = String.valueOf(dataRoom.get(position).getGetGiaTienTheoNgay());
                            priceHours =String.valueOf(dataRoom.get(position).getGiaTienTheoGio());
                            idKhachSan= dataRoom.get(position).getIdKhachSan();
                            idRoom = dataRoom.get(position).getIdPhong();
                            nameRoom.setText(dataRoom.get(position).getNameRoom());
                            tvPriceDay.setText(priceDay);
                            tvPriceHours.setText(priceHours);
                        }
                        else if(dataRoom.get(position).getTrangThai() == 1){
                            DialogCheckBooking();
                            idRoom = dataRoom.get(position).getIdPhong();
                            nameRoom.setText(dataRoom.get(position).getNameRoom());
                            tenPhong = dataRoom.get(position).getNameRoom();
                            database.child("BookingRoom").addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                    DatPhong dt = snapshot.getValue(DatPhong.class);
                                    if (dataRoom.get(position).getIdPhong().equals(dt.getIdPhong()) && dt.getTrangThai() == 1){
                                        idBooking = snapshot.getKey();
                                        edtName.setText(dt.getTen());
                                        edtPhone.setText(dt.getSdt());
                                        edcmnd.setText(dt.getCmnd());
                                        edtTienCoc.setText(String.valueOf(dt.getdTienCoc()));
                                        edtPriceTotal.setText(String.valueOf(dt.getdTongTien()));
                                        if (dt.getLoaiDat()==1){
//                                            Booking day
                                            radioBookingDay.setChecked(true);
                                            radioBookingHours.setChecked(false);
                                            selectionBookingHours.setVisibility(View.GONE);
                                            selectionBookingDay.setVisibility(View.VISIBLE);
                                            edtCheckinDay.setText(dt.getGioThue());
                                            edtChekoutDay.setText(dt.getGioTra());
                                            edtPriceRoom.setText(String.valueOf(dataRoom.get(position).getGetGiaTienTheoNgay()));
                                            edtPriceDay.setText(String.valueOf(dataRoom.get(position).getGetGiaTienTheoNgay()));
                                            totalTimeDay.setText(String.valueOf(dt.getThoiGianThue()));
                                        }
                                        if(dt.getLoaiDat() == 0){
//                                            Booking hours
                                            radioBookingHours.setChecked(true);
                                            radioBookingDay.setChecked(false);
                                            selectionBookingDay.setVisibility(View.GONE);
                                            selectionBookingHours.setVisibility(View.VISIBLE);
                                            edtTimeIn.setText(dt.getGioThue());
                                            edtTimeOut.setText(dt.getGioTra());
                                            edtPriceRoom.setText(String.valueOf(dataRoom.get(position).getGiaTienTheoGio()));
                                            edtPriceHours.setText(String.valueOf(dataRoom.get(position).getGiaTienTheoGio()));
                                            totalTimeHours.setText(String.valueOf(dt.getThoiGianThue()));
                                        }
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
                        }
                        else if(dataRoom.get(position).getTrangThai() == 2){
                            Toast.makeText(context,"Phòng này đang chờ duyệt",Toast.LENGTH_SHORT).show();
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
                }
                if(radioBookingHours.isChecked()){
                    price = Integer.parseInt(priceHours);
                    gioDat = edtTimeIn.getText().toString();
                    gioTra = edtTimeOut.getText().toString();
                    totalTime = Integer.parseInt(totalTimeHours.getText().toString());
                    dayHours = edtDayHours.getText().toString();
                    loaiDat =0;
                }
                database.child("BookingRoom").push().setValue(new DatPhong("Admin",idKhachSan,idRoom,null,gioDat,gioTra,ten,sdt,cmnd,dayHours,loaiDat,price,0,1,totalTime,tenPhong));
                database.child("Phong").child(idRoom).child("trangThai").setValue(1);
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

    Dialog dialog;
    // đã đặt phòng
    private void DialogCheckBooking() {
        dialog = new Dialog(context, R.style.Widget_AppCompat_ActionBar_Solid);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_check_booking);
        radioBookingDay = dialog.findViewById(R.id.radioBookingDay);
        radioBookingHours = dialog.findViewById(R.id.radioBookingHours);
        selectionBookingDay = dialog.findViewById(R.id.bookingDay);
        selectionBookingHours = dialog.findViewById(R.id.bookingHours);
        radioGroup = dialog.findViewById(R.id.rdgButton);
        edtCheckinDay = dialog.findViewById(R.id.edtCheckinDay);
        edtChekoutDay = dialog.findViewById(R.id.edtCheckOutDay);
        edtDayHours = dialog.findViewById(R.id.edtDayHours);
        edtTimeIn = dialog.findViewById(R.id.edtTimeIn);
        edtTimeOut = dialog.findViewById(R.id.edtTimeOut);
        nameRoom = dialog.findViewById(R.id.nameRoom);
        edtName = dialog.findViewById(R.id.edtName);
        edtPhone = dialog.findViewById(R.id.edtPhone);
        edcmnd = dialog.findViewById(R.id.cmnd);
        totalTimeHours = dialog.findViewById(R.id.totalTimeHours);
        totalTimeDay = dialog.findViewById(R.id.totalTimeDay);
        edtPriceDay = dialog.findViewById(R.id.priceDay);
        edtPriceHours = dialog.findViewById(R.id.priceHours);
        edtTienCoc = dialog.findViewById(R.id.edtTienCoc);
        edtPriceRoom = dialog.findViewById(R.id.edtPriceRoom);
        edtPriceTotal = dialog.findViewById(R.id.edtPriceTotal);
        ClickButton(dialog);

        edtName.setEnabled(false);
        edcmnd.setEnabled(false);
        edtPhone.setEnabled(false);
        edtCheckinDay.setEnabled(false);
        edtChekoutDay.setEnabled(false);
        edtTimeIn.setEnabled(false);
        edtTimeOut.setEnabled(false);
        edtDayHours.setEnabled(false);
        totalTimeDay.setEnabled(false);
        totalTimeHours.setEnabled(false);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.child("Phong").child(idRoom).child("trangThai").setValue(0);
                database.child("BookingRoom").child(idBooking).child("trangThai").setValue(0);
                dialog.dismiss();
                Toast.makeText(context , "Thanh toán thành công",Toast.LENGTH_SHORT).show();
            }
        });

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                View radioButton = radioGroup.findViewById(checkedId);
//                int index = radioGroup.indexOfChild(radioButton);
//                switch (index) {
//                    case 0:
//                        selectionBookingHours.setVisibility(View.GONE);
//                        selectionBookingDay.setVisibility(View.VISIBLE);
//                        break;
//                    case 1:
//                        selectionBookingDay.setVisibility(View.GONE);
//                        selectionBookingHours.setVisibility(View.VISIBLE);
//                        break;
//                }
//            }
//        });
//        edtCheckinDay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SeclectDay(edtCheckinDay);
//            }
//        });
//        edtChekoutDay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SeclectDay(edtChekoutDay);
//            }
//        });
//        edtDayHours.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SeclectDay(edtDayHours);
//            }
//        });
//        TODO: select time in and select time out
//        edtTimeIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SelectTime(edtTimeIn);
//            }
//        });
//        edtTimeOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SelectTime(edtTimeOut);
//            }
//        });
        dialog.show();
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