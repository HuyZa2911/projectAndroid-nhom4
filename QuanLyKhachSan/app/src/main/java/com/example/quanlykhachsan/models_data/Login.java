package com.example.quanlykhachsan.models_data;

public class Login {

    private String userName;
    private String pass;
    private String phone;
    private String mail;
    private String idChuKS;
    private int role;

    public int getRole() {
        return role;
    }

    public String getIdChuKS() {
        return idChuKS;
    }

    public void setIdChuKS(String idChuKS) {
        this.idChuKS = idChuKS;
    }

    public void setRole(int role) {
        this.role = role;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public Login() {
    }

    public Login(String idChuKS, String userName, String pass, String phone,int role) {
        this.idChuKS = idChuKS;
        this.userName = userName;
        this.pass = pass;
        this.phone = phone;
        this.role = role;
    }
}
