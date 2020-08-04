package com.example.quanlykhachsan.models_manage_data;

import com.example.quanlykhachsan.models_data.TaiKhoan;

import java.util.ArrayList;

public class ListKhachHang {
    private ArrayList<TaiKhoan> listCustomer;

    public void addCustomer(TaiKhoan taiKhoan){
        listCustomer.add(taiKhoan);
    }
    public ArrayList<TaiKhoan> getListCustomer() {
        return listCustomer;
    }


    public void setListCustomer(TaiKhoan... taiKhoans) {
        for (TaiKhoan taiKhoan : taiKhoans)
        {
            listCustomer.add(taiKhoan);
        }

    }

    public ListKhachHang() {
    }

    public ListKhachHang(ArrayList<TaiKhoan> listCustomer) {
        this.listCustomer = listCustomer;
    }
}
