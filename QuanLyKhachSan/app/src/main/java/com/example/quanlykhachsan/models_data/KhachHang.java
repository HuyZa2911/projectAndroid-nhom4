package com.example.quanlykhachsan.models_data;

import java.util.Date;

public class KhachHang {
    private int idPhong;
    private String hoTen;
    private String sdt;
    private String ngayThue;
    private String ngayTra;
    private String diaChi;
    private int soGioThue;

    public KhachHang(int idPhong, String hoTen, String sdt, String ngayThue, String ngayTra, String diaChi, int soGioThue) {
        this.idPhong = idPhong;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.diaChi = diaChi;
        this.soGioThue = soGioThue;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoGioThue() {
        return soGioThue;
    }

    public void setSoGioThue(int soGioThue) {
        this.soGioThue = soGioThue;
    }
}