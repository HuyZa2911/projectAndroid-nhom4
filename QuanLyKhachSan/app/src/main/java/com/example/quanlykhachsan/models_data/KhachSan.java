package com.example.quanlykhachsan.models_data;

import com.example.quanlykhachsan.models_manage_data.ListPhong;

import java.util.ArrayList;

public class KhachSan {
    private int idKhachSan;

    private String tenKS;
    private String diaChi;
    private int loaiKS;

    public int getIdKhachSan() {
        return idKhachSan;
    }

    public void setIdKhachSan(int idKhachSan) {
        this.idKhachSan = idKhachSan;
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

    public KhachSan(int idKhachSan, String tenKS, String diaChi, int loaiKS) {
        this.idKhachSan = idKhachSan;
        this.tenKS = tenKS;
        this.diaChi = diaChi;
        this.loaiKS = loaiKS;
    }
}
