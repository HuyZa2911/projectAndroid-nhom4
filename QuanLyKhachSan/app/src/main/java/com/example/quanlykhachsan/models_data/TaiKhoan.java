package com.example.quanlykhachsan.models_data;

public class TaiKhoan {

    private String userName;
    private String pass;
    private String phone;
//    private String mail;
    private int role;

    public int getRole() {
        return role;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getMail() {
//        return mail;
//    }

//    public void setMail(String mail) {
//        this.mail = mail;
//    }
    public TaiKhoan() {
    }

    public TaiKhoan( String userName, String pass, String phone,int role) {
        this.userName = userName;
        this.pass = pass;
        this.phone = phone;
//        this.mail = mail;
        this.role = role;
    }
}
