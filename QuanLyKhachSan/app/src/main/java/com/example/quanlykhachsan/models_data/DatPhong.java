package com.example.quanlykhachsan.models_data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class DatPhong {
    private int idUser, idKhachSan, idPhong, thoiGianThue, idDatPhong;
    private TaiKhoan taiKhoan;
    private int trangThai = 0;
    private Date ngayThue, ngayTra;
    private Double dTongTien, dTienCoc;
    private Timestamp thoiGianDat;

    public int getIdDatPhong() {
        return idDatPhong;
    }

    public void setIdDatPhong(int idDatPhong) {
        this.idDatPhong = idDatPhong;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }


    public DatPhong(int idUser, int idKhachSan, int idPhong, int thoiGianThue, int idDatPhong, TaiKhoan taiKhoan, int trangThai, Date ngayThue, Date ngayTra, Double dTongTien, Double dTienCoc, Timestamp thoiGianDat) {
        this.idUser = idUser;
        this.idKhachSan = idKhachSan;
        this.idPhong = idPhong;
        this.thoiGianThue = thoiGianThue;
        this.idDatPhong = idDatPhong;
        this.taiKhoan = taiKhoan;
        this.trangThai = trangThai;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.dTongTien = dTongTien;
        this.dTienCoc = dTienCoc;
        this.thoiGianDat = thoiGianDat;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdKhachSan() {
        return idKhachSan;
    }

    public void setIdKhachSan(int idKhachSan) {
        this.idKhachSan = idKhachSan;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public int getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(int thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Double getdTongTien() {
        return dTongTien;
    }

    public void setdTongTien(Double dTongTien) {
        this.dTongTien = dTongTien;
    }

    public Double getdTienCoc() {
        return dTienCoc;
    }

    public void setdTienCoc(Double dTienCoc) {
        this.dTienCoc = dTienCoc;
    }

    public Timestamp getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Timestamp thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }


}
