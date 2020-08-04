package com.example.quanlykhachsan.models_data;

public class CardViewModel {
    private int getImvImageHotel;
    private String giaTheoGio;
    private String giaTheoNgay;
    private String tinhTrang;

    public CardViewModel(int getImvImageHotel, String giaTheoGio, String giaTheoNgay, String tinhTrang) {
        this.getImvImageHotel = getImvImageHotel;
        this.giaTheoGio = giaTheoGio;
        this.giaTheoNgay = giaTheoNgay;
        this.tinhTrang = tinhTrang;
    }

    public int getGetImvImageHotel() {
        return getImvImageHotel;
    }

    public void setGetImvImageHotel(int getImvImageHotel) {
        this.getImvImageHotel = getImvImageHotel;
    }

    public String getGiaTheoGio() {
        return giaTheoGio;
    }

    public void setGiaTheoGio(String giaTheoGio) {
        this.giaTheoGio = giaTheoGio;
    }

    public String getGiaTheoNgay() {
        return giaTheoNgay;
    }

    public void setGiaTheoNgay(String giaTheoNgay) {
        this.giaTheoNgay = giaTheoNgay;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
