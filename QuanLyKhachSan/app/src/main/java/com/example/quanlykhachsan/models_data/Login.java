package com.example.quanlykhachsan.models_data;

public class Login {
    public String email;
    public String name;
    public String password;
    public int role;

    public Login() {
    }

    public Login(String email, String name, String password, int role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
