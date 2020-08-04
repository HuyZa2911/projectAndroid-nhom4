package com.example.quanlykhachsan.models_manage_data;

import com.example.quanlykhachsan.models_data.Phong;

import java.util.ArrayList;

public class ListPhong {
    private ArrayList<Phong> listPhong;



    public void updatePhong(Phong phong) {
        for (Phong phong1 : listPhong) {
            if (phong1.getIdPhong() == phong.getIdPhong()) {
//                phong1.setGiaPhong(phong.getGiaPhong());
                phong1.setLoaiPhong(phong.getLoaiPhong());
                phong1.setSoGiuong(phong.getSoGiuong());
                phong1.setTrangThai(phong.getTrangThai());
                break;
            }

        }

    }
    public void deletePhong(Phong phong){
        for (Phong phong1 : listPhong) {
            if (phong1.getIdPhong() == phong.getIdPhong()) {
                listPhong.remove(phong1);
                break;
            }

        }
    }
    public void addPhong(Phong phong){
        listPhong.add(phong);
    }
    public ArrayList<Phong> getListPhong(Phong... phongs) {
        for (Phong phong1 : phongs)
            this.listPhong.add(phong1);
        return listPhong;
    }

    public void setListPhong(ArrayList<Phong> listPhong) {
        this.listPhong = listPhong;
    }

    public ListPhong(ArrayList<Phong> listPhong) {
        this.listPhong = listPhong;
    }
}
