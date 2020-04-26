
/**
 * <一句话功能简述>
 * <p>
 * 订单明细
 *
 * @author sunmeng
 * @create 2020/3/16   10:14
 */
package com.it.domain;

import java.io.Serializable;

public class Order_details implements Serializable {
    private String order_id;      //订单ID
    private String product_id;      //产品ID
    private String farmers_id;      //农户ID
    private Double numbers;     //产品数量
    private Double unit_price;      //单价
    private Double price;       //单项订单价格


    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

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

    public Double getNumbers() {
        return numbers;
    }

    public void setNumbers(Double numbers) {
        this.numbers = numbers;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Order_details{" +
                "order_id='" + order_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", farmers_id='" + farmers_id + '\'' +
                ", numbers=" + numbers +
                ", unit_price=" + unit_price +
                ", price=" + price +
                '}';
    }
}
