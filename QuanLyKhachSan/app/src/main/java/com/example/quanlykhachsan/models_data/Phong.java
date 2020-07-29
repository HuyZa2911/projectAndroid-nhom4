package com.example.quanlykhachsan.models_data;

public class Phong {
    private int idPhong;
    private int idKhachSan;
    private int soGiuong;
    private int loaiPhong;
    private double giaPhong;
    private int trangThai;
    private Double giaTienTheoGio;
    private Double getGiaTienTheoNgay;

    public Double getGiaTienTheoGio() {
        return giaTienTheoGio;
    }

    public void setGiaTienTheoGio(Double giaTienTheoGio) {
        this.giaTienTheoGio = giaTienTheoGio;
    }

    public Double getGetGiaTienTheoNgay() {
        return getGiaTienTheoNgay;
    }

    public void setGetGiaTienTheoNgay(Double getGiaTienTheoNgay) {
        this.getGiaTienTheoNgay = getGiaTienTheoNgay;
    }

    public Phong(int idPhong, int idKhachSan, int soGiuong, int loaiPhong, double giaPhong, int trangThai, Double giaTienTheoGio, Double getGiaTienTheoNgay) {
        this.idPhong = idPhong;
        this.idKhachSan = idKhachSan;
        this.soGiuong = soGiuong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.trangThai = trangThai;
        this.giaTienTheoGio = giaTienTheoGio;
        this.getGiaTienTheoNgay = getGiaTienTheoNgay;
    }

    public int getIdKhachSan() {
        return idKhachSan;
    }

    public void setIdKhachSan(int idKhachSan) {
        this.idKhachSan = idKhachSan;
    }

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

}
