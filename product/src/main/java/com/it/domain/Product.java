package com.it.domain;/*
@author Laotian
@create 2020-03-10-11:24
*/

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private String product_id;
    private String farmers_id;
    private String product_name;
    private String unit;
    private Double unit_price;
    private String introduce;
    private String image_path;
    private String product_gross;
    private String specification;

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


    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", farmers_id='" + farmers_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", unit='" + unit + '\'' +
                ", unit_price=" + unit_price +
                ", introduce='" + introduce + '\'' +
                ", image_path='" + image_path + '\'' +
                ", product_gross='" + product_gross + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}
