package com.example.quanlykhachsan.models_data;

public class KhachSan {
    private String idChuKS;
    private String tenKS;
    private String diaChi;
    private String giaTheoNgay;
    private String giaTheoGio;
    private int numberRoom;
    private int phone;
    private int loaiKS;

    public String getGiaTheoNgay() {
        return giaTheoNgay;
    }

    public String getGiaTheoGio() {
        return giaTheoGio;
    }

    public int getNuberRoom() {
        return numberRoom;
    }

    public void setNuberRoom(int nuberRoom) {
        this.numberRoom = nuberRoom;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    public String getIdChuKS() {
        return idChuKS;
    }

    public void setIdChuKS(String idChuKS) {
        this.idChuKS = idChuKS;
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

    public KhachSan() {
    }

    public KhachSan(String idChuKS, String tenKS, String diaChi, String giaTheoNgay, String giaTheoGio, int nuberRoom, int phone, int loaiKS) {
        this.idChuKS = idChuKS;
        this.tenKS = tenKS;
        this.diaChi = diaChi;
        this.giaTheoNgay = giaTheoNgay;
        this.giaTheoGio = giaTheoGio;
        this.numberRoom = nuberRoom;
        this.phone = phone;
        this.loaiKS = loaiKS;
    }
}
