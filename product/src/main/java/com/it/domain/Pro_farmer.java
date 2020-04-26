package com.it.domain;/*
@author Laotian
@create 2020-03-13-12:14
*/

import java.io.Serializable;
import java.util.Date;

public class Pro_farmer implements Serializable {
    private String product_id;
    private String farmers_id;
    private String product_name;
    private String unit;
    private Double unit_price;
    private String introduce;
    private String image_path;
    private String product_gross;
    private Double freight;
    private String specification;
    private String county;
    private String farmers_name;
    private String farmers_tel;
    private String farmers_addr;
    private String qrcode;
    private String addtime;
    private Double low_income_level;
    private Integer is_cross_level;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getFarmers_id() {
        return farmers_id;
    }

    public void setFarmers_id(String farmers_id) {
        this.farmers_id = farmers_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getProduct_gross() {
        return product_gross;
    }

    public void setProduct_gross(String product_gross) {
        this.product_gross = product_gross;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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
        return "Pro_farmer{" +
                "product_id='" + product_id + '\'' +
                ", farmers_id='" + farmers_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", unit='" + unit + '\'' +
                ", unit_price=" + unit_price +
                ", introduce='" + introduce + '\'' +
                ", image_path='" + image_path + '\'' +
                ", product_gross='" + product_gross + '\'' +
                ", freight=" + freight +
                ", specification='" + specification + '\'' +
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
