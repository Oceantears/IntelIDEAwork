package com.it.domain;/*
@author Laotian
@create 2020-03-10-10:50
*/

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    private String cus_id;//客户ID
    private String cus_anme;//客户名称
    private String cus_addr;//地址
    private String cus_tel;//客户电话
    private String contacts;//联系人
    private String cus_type;//客户类型
    private String wechat_id;//微信号

    private List<String> order_detailsList;            //客户对应的所有订单号

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_anme() {
        return cus_anme;
    }

    public void setCus_anme(String cus_anme) {
        this.cus_anme = cus_anme;
    }

    public String getCus_addr() {
        return cus_addr;
    }

    public void setCus_addr(String cus_addr) {
        this.cus_addr = cus_addr;
    }

    public String getCus_tel() {
        return cus_tel;
    }

    public void setCus_tel(String cus_tel) {
        this.cus_tel = cus_tel;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getCus_type() {
        return cus_type;
    }

    public void setCus_type(String cus_type) {
        this.cus_type = cus_type;
    }

    public String getWechat_id() {
        return wechat_id;
    }

    public void setWechat_id(String wechat_id) {
        this.wechat_id = wechat_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id='" + cus_id + '\'' +
                ", cus_anme='" + cus_anme + '\'' +
                ", cus_addr='" + cus_addr + '\'' +
                ", cus_tel='" + cus_tel + '\'' +
                ", contacts='" + contacts + '\'' +
                ", cus_type='" + cus_type + '\'' +
                ", wechat_id='" + wechat_id + '\'' +
                '}';
    }
}
