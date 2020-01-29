package com.softwarica.airlinereservationsystem.model;

public class User {
    private String fullname;
    private String phone;
    private String address;
    private String email;
    private String password;
    private String conpassword;
    private String image;

    public User(String fullname, String phone, String address, String email, String password, String conpassword, String image) {
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.conpassword = conpassword;
        this.image = image;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
