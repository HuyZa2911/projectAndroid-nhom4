package com.example.quanlykhachsan.models_data;

public class Phong {
    private int idPhong;
    private int soGiuong;
    private int loaiPhong;
    private double giaPhong;
    private int trangThai;

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public void setLoaiPhong(int loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public int getLoaiPhong() {
        return loaiPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public Phong() {
    }

    public Phong(int idPhong, int soGiuong, int loaiPhong, double giaPhong, int trangThai) {
        this.idPhong = idPhong;
        this.soGiuong = soGiuong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.trangThai = trangThai;
    }
}
