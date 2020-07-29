package com.example.quanlykhachsan.models_data;

public class KhachSan {
    private String idChuKS;
    private String tenKS;
    private String diaChi;
    private int nuberRoom;
    private int phone;

    public int getNuberRoom() {
        return nuberRoom;
    }

    public void setNuberRoom(int nuberRoom) {
        this.nuberRoom = nuberRoom;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private int loaiKS;

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

    public KhachSan(String idChuKS, String tenKS, String diaChi, int loaiKS,int phone,int numberRoom) {
        this.idChuKS = idChuKS;
        this.tenKS = tenKS;
        this.diaChi = diaChi;
        this.loaiKS = loaiKS;
        this.phone = phone;
        this.nuberRoom =numberRoom;
    }
}
