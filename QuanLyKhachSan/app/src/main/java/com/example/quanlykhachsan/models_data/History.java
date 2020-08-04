package com.example.quanlykhachsan.models_data;

public class History {
    private String idUser;
    private String time;
    private  String nameHottel;
    private String diaChi;
    private String price;
    private int status;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameHottel() {
        return nameHottel;
    }

    public void setNameHottel(String nameHottel) {
        this.nameHottel = nameHottel;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public History() {
    }

    public History(String idUser,String time, String nameHottel, String diaChi, String price, int status) {
        this.idUser = idUser;
        this.time = time;
        this.nameHottel = nameHottel;
        this.diaChi = diaChi;
        this.price = price;
        this.status = status;
    }
}
