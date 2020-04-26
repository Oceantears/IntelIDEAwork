package com.it.domain;/*
@author Laotian
@create 2020-03-10-11:20
*/

import java.io.Serializable;
import java.util.Date;

public class Farmers implements Serializable {
    private String farmers_id;
    private String county;
    private String farmers_name;
    private String farmers_tel;
    private String farmers_addr;
    private String qrcode;
    private String addtime;
    private Double low_income_level;
    private Integer is_cross_level;


    public String getFarmers_id() {
        return farmers_id;
    }

    public void setFarmers_id(String farmers_id) {

        this.farmers_id = farmers_id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getFarmers_name() {
        return farmers_name;
    }

    public void setFarmers_name(String farmers_name) {
        this.farmers_name = farmers_name;
    }

    public String getFarmers_tel() {
        return farmers_tel;
    }

    public void setFarmers_tel(String farmers_tel) {
        this.farmers_tel = farmers_tel;
    }

    public String getFarmers_addr() {
        return farmers_addr;
    }

    public void setFarmers_addr(String farmers_addr) {
        this.farmers_addr = farmers_addr;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Double getLow_income_level() {
        return low_income_level;
    }

    public void setLow_income_level(Double low_income_level) {
        this.low_income_level = low_income_level;
    }

    public Integer getIs_cross_level() {
        return is_cross_level;
    }

    public void setIs_cross_level(Integer is_cross_level) {
        this.is_cross_level = is_cross_level;
    }

    @Override
    public String toString() {
        return "Farmers{" +
                "farmers_id='" + farmers_id + '\'' +
                ", county='" + county + '\'' +
                ", farmers_name='" + farmers_name + '\'' +
                ", farmers_tel='" + farmers_tel + '\'' +
                ", farmers_addr='" + farmers_addr + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", addtime='" + addtime + '\'' +
                ", low_income_level=" + low_income_level +
                ", is_cross_level=" + is_cross_level +
                '}';
    }
}
