package com.bean;

public class User {
    private  Integer KEYID;//ID
    private  String USERNAME;//姓名
    private  String PWD;//密码

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    @Override
    public String toString() {
        return "User{" +
                "KEYID=" + KEYID +
                ", USERNAME='" + USERNAME + '\'' +
                ", PWD='" + PWD + '\'' +
                '}';
    }
}
