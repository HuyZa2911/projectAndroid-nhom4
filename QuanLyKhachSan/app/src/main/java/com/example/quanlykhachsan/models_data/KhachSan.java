package com.example.quanlykhachsan.models_data;

import java.util.ArrayList;

public class KhachSan {
    private int idKhachSan;
    private ArrayList<Phong> arrayListPhong;
    private String tenKS;
    private String diaChi;
    private int loaiKS;

    public void addPhong(Phong phong) {
        arrayListPhong.add(phong);
    }

    public void updatePhong(Phong phong) {
        for (Phong phong1 : arrayListPhong) {
            if (phong1.getIdPhong() == phong.getIdPhong()) {
                phong1.setGiaPhong(phong.getGiaPhong());
                phong1.setLoaiPhong(phong.getLoaiPhong());
                phong1.setSoGiuong(phong.getSoGiuong());
                phong1.setTrangThai(phong.getTrangThai());
                break;
            }

        }

    }
    public void deletePhong(Phong phong){
        for (Phong phong1 : arrayListPhong) {
            if (phong1.getIdPhong() == phong.getIdPhong()) {
                arrayListPhong.remove(phong1);
                break;
            }

        }
    }
    public KhachSan(int idKhachSan, ArrayList<Phong> arrayListPhong, String tenKS, String diaChi, int loaiKS) {
        this.idKhachSan = idKhachSan;
        this.arrayListPhong = arrayListPhong;
        this.tenKS = tenKS;
        this.diaChi = diaChi;
        this.loaiKS = loaiKS;
    }

    public int getIdKhachSan() {
        return idKhachSan;
    }

    public void setIdKhachSan(int idKhachSan) {
        this.idKhachSan = idKhachSan;
    }

    public ArrayList<Phong> getArrayListPhong() {
        return arrayListPhong;
    }

    public void setArrayListPhong(Phong... phong) {
        for (Phong phong1 : phong)
            this.arrayListPhong.add(phong1);
    }

    public String getTenKS() {
        return tenKS;
    }

    public void setTenKS(String tenKS) {
        this.tenKS = tenKS;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getLoaiKS() {
        return loaiKS;
    }

    public void setLoaiKS(int loaiKS) {
        this.loaiKS = loaiKS;
    }
}
