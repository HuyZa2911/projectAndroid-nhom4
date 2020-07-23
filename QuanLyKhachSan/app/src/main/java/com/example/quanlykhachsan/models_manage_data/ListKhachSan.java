package com.example.quanlykhachsan.models_manage_data;

import com.example.quanlykhachsan.models_data.KhachSan;
import com.example.quanlykhachsan.models_data.Phong;

import java.util.ArrayList;

public class ListKhachSan {
    ArrayList<KhachSan> listKhachSan;

    public ArrayList<KhachSan> getListKhachSan() {
        return listKhachSan;
    }

    public void updateKhachSan(KhachSan khachSan) {
        for (KhachSan khachSan1 : listKhachSan) {
            if (khachSan1.getIdKhachSan() == khachSan.getIdKhachSan()) {
                for (Phong phong : khachSan.getArrayListPhong()) {
                    khachSan1.setArrayListPhong(phong);
                }
                khachSan1.setDiaChi(khachSan.getDiaChi());
                khachSan1.setLoaiKS(khachSan.getLoaiKS());
                khachSan1.setTenKS(khachSan.getTenKS());
                break;
            }
        }
    }

    public void deleteKhachSan(KhachSan khachSan) {
        for (KhachSan khachSan1 : listKhachSan) {
            if (khachSan1.getIdKhachSan() == khachSan.getIdKhachSan()) {
                listKhachSan.remove(khachSan1);
                break;
            }
        }
    }

    public void addKhachSan(KhachSan khachSan) {
        listKhachSan.add(khachSan);

    }

    public void setListKhachSan(KhachSan... arrkhachSan) {
        for (KhachSan khachSan : arrkhachSan) {
            listKhachSan.add(khachSan);
        }
    }

    public ListKhachSan(ArrayList<KhachSan> listKhachSan) {
        this.listKhachSan = listKhachSan;
    }
}
