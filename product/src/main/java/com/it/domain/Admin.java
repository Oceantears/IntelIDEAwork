package com.it.domain;/*
@author Laotian
@create 2020-03-10-10:46
*/

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer id;//ID
    private String admin;//管理员
    private String name;//用户名
    private String password;//密码

    public Admin() {
    }

    public Admin(Integer id, String admin, String name, String password) {
        this.id = id;
        this.admin = admin;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", admin='" + admin + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
