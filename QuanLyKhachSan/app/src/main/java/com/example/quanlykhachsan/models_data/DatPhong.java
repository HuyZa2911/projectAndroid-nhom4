package com.example.quanlykhachsan.models_data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class DatPhong {
    private String idUser;
    private String idKhachSan;
    private String idPhong;
    private String idHistory;
    private String gioThue;
    private String gioTra;
    private String ten;
    private String sdt;
    private String cmnd;
    private String dayHours;
    private int loaiDat;
    private int dTongTien;
    private int dTienCoc;
    private int trangThai = 0;
    private int thoiGianThue;

    public String getDayHours() {
        return dayHours;
    }

    public String getTen() {
        return ten;
    }

    public int getLoaiDat() {
        return loaiDat;
    }

    public String getSdt() {
        return sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdKhachSan() {
        return idKhachSan;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public int getThoiGianThue() {
        return thoiGianThue;
    }

    public String getIdHistory() {
        return idHistory;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public String getGioThue() {
        return gioThue;
    }

    public String getGioTra() {
        return gioTra;
    }

    public int getdTongTien() {
        return dTongTien;
    }

    public int getdTienCoc() {
        return dTienCoc;
    }

    public DatPhong(String idUser, String idKhachSan, String idPhong, String idHistory, String gioThue, String gioTra, String ten, String sdt, String cmnd,String dayHours, int loaiDat, int dTongTien, int dTienCoc, int trangThai, int thoiGianThue) {
        this.idUser = idUser;
        this.idKhachSan = idKhachSan;
        this.idPhong = idPhong;
        this.idHistory = idHistory;
        this.gioThue = gioThue;
        this.gioTra = gioTra;
        this.ten = ten;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.loaiDat = loaiDat;
        this.dTongTien = dTongTien;
        this.dTienCoc = dTienCoc;
        this.trangThai = trangThai;
        this.thoiGianThue = thoiGianThue;
        this.dayHours = dayHours;
    }

    public DatPhong() {
    }
}
