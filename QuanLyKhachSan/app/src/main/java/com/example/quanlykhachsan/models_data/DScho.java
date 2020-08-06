package com.example.quanlykhachsan.models_data;

public class DScho {
    String idPhong;
    String idUser;
    String idHistory;
    String ten;
    String nameRoom;
    String diaChi;
    String loai;
    String gioThue;
    String gioTra;
    String thoiGian;
    String sdt;

    public String getIdPhong() {
        return idPhong;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdHistory() {
        return idHistory;
    }

    public String getTen() {
        return ten;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getLoai() {
        return loai;
    }

    public String getGioThue() {
        return gioThue;
    }

    public String getGioTra() {
        return gioTra;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public String getSdt() {
        return sdt;
    }

    public DScho(String idPhong, String idUser, String idHistory, String ten, String nameRoom, String diaChi, String loai, String gioThue, String gioTra, String thoiGian, String sdt) {
        this.idPhong = idPhong;
        this.idUser = idUser;
        this.idHistory = idHistory;
        this.ten = ten;
        this.nameRoom = nameRoom;
        this.diaChi = diaChi;
        this.loai = loai;
        this.gioThue = gioThue;
        this.gioTra = gioTra;
        this.thoiGian = thoiGian;
        this.sdt = sdt;
    }

    public DScho() {
    }
}
