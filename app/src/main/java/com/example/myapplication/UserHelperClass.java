package com.example.myapplication;

public class UserHelperClass {
    String name, username, email, phoneno, password, cmc, bmc, address;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String username, String email, String phoneno, String password, String cmc, String bmc, String address) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phoneno = phoneno;
        this.password = password;
        this.cmc = cmc;
        this.bmc = bmc;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCmc() {
        return cmc;
    }

    public void setCmc(String cmc) {
        this.cmc = cmc;
    }

    public String getBmc() {
        return bmc;
    }

    public void setBmc(String bmc) {
        this.bmc = bmc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

