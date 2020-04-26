/**
 * 产品组成实体类
 */
package com.it.domain;

import java.io.Serializable;

/**
 * @author Laotian
 * @date 2020-03-20 9:52
 */
public class Pro_form_info implements Serializable {
    private Integer id; //ID
    private String product_id; //产品id
    private String project_id; //项目id
    private String proj_constitute; //组成对象
    private String proj_classes; //组成类别
    private Double proj_price; //组成对象金额
    private String percent; //所占比例

    private Product product; //产品类对象

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProj_constitute() {
        return proj_constitute;
    }

    public void setProj_constitute(String proj_constitute) {
        this.proj_constitute = proj_constitute;
    }

    public String getProj_classes() {
        return proj_classes;
    }

    public void setProj_classes(String proj_classes) {
        this.proj_classes = proj_classes;
    }

    public Double getProj_price() {
        return proj_price;
    }

    public void setProj_price(Double proj_price) {
        this.proj_price = proj_price;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Pro_form_info{" +
                "id=" + id +
                ", product_id='" + product_id + '\'' +
                ", project_id='" + project_id + '\'' +
                ", proj_constitute='" + proj_constitute + '\'' +
                ", proj_classes='" + proj_classes + '\'' +
                ", proj_price=" + proj_price +
                ", percent='" + percent + '\'' +
                ", product=" + product +
                '}';
    }
}