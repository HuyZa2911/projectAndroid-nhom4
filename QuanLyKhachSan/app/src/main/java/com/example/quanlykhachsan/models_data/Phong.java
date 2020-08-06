package com.example.quanlykhachsan.models_data;

public class Phong {
    private String idPhong;
    private String idKhachSan;
    private String nameRoom;
    private int soGiuong;
    private int loaiPhong;
    private int trangThai;
    private int giaTienTheoGio;
    private int getGiaTienTheoNgay;

    public int getGiaTienTheoGio() {
        return giaTienTheoGio;
    }

    public void setGiaTienTheoGio(int giaTienTheoGio) {
        this.giaTienTheoGio = giaTienTheoGio;
    }

    public int getGetGiaTienTheoNgay() {
        return getGiaTienTheoNgay;
    }

    public void setGetGiaTienTheoNgay(int  getGiaTienTheoNgay) {
        this.getGiaTienTheoNgay = getGiaTienTheoNgay;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public Phong(String idPhong, String idKhachSan, String nameRoom , int soGiuong, int loaiPhong, int trangThai, int giaTienTheoGio, int getGiaTienTheoNgay) {
        this.idPhong = idPhong;
        this.idKhachSan = idKhachSan;
        this.nameRoom = nameRoom;
        this.soGiuong = soGiuong;
        this.loaiPhong = loaiPhong;
        this.trangThai = trangThai;
        this.giaTienTheoGio = giaTienTheoGio;
        this.getGiaTienTheoNgay = getGiaTienTheoNgay;
    }

    public String getIdKhachSan() {
        return idKhachSan;
    }

    public void setIdKhachSan(String idKhachSan) {
        this.idKhachSan = idKhachSan;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public void setLoaiPhong(int loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public int getLoaiPhong() {
        return loaiPhong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public Phong() {
    }

}
