package com.example.quanlykhachsan;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TestDialog extends AppCompatActivity {
    Button btnBooking;
    Button buttonBookingTest;
    LinearLayout selectionBookingDay;
    LinearLayout selectionBookingHours;
    RadioButton radioBookingDay;
    RadioButton radioBookingHours;
    RadioGroup radioGroup;
    Button btnCancel;
    Button btnConfirm;
    EditText edtCheckinDay, edtChekoutDay, edtDayHours, edtTimeIn, edtTimeOut;
    ImageView btnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);
        btnBooking = findViewById(R.id.buttonBooking);
        buttonBookingTest = findViewById(R.id.buttonBookingTest);
        clickBooking();
        buttonBookingTest();
    }

    private void clickBooking() {
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBooking(v);
            }
        });
    }

    private void buttonBookingTest() {
        buttonBookingTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCheckBooking();
            }
        });
    }

    private void DialogBooking(View v) {
        final Dialog dialog = new Dialog(this, R.style.MyAlertDialogTheme);
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
//        TODO: set event click button
        ClickButton(dialog);
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

    // TODO: layout dialog booking hours
    private void DialogCheckBooking() {
        final Dialog dialog = new Dialog(this, R.style.Widget_AppCompat_ActionBar_Solid);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_check_booking);
        selectionBookingDay = dialog.findViewById(R.id.bookingDay);
        selectionBookingHours = dialog.findViewById(R.id.bookingHours);
        radioGroup = dialog.findViewById(R.id.rdgButton);
        edtCheckinDay = dialog.findViewById(R.id.edtCheckinDay);
        edtChekoutDay = dialog.findViewById(R.id.edtCheckOutDay);
        edtDayHours = dialog.findViewById(R.id.edtDayHours);
        edtTimeIn = dialog.findViewById(R.id.edtTimeIn);
        edtTimeOut = dialog.findViewById(R.id.edtTimeOut);
        ClickButton(dialog);
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
//        TODO: select time in and select time out
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
        dialog.show();
    }

    // TODO: layout check booking dialog
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

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private void SeclectDay(final EditText dateInput) {
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        TestDialog.this,
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
                mTimePicker = new TimePickerDialog(TestDialog.this, new TimePickerDialog.OnTimeSetListener() {
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