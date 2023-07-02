package com.air.pojo;/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 14:22
* @version 1.0
*/

public class User {
    private String username;
    private String password;
    private String tel;
    private String name;

    public User() {
    }

    public User(String username, String password, String tel, String name) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
