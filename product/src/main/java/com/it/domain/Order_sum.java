
/**
 * <一句话功能简述>
 * <p>
 * 订单汇总
 *
 * @author sunmeng
 * @create 2020/3/16   10:14
 */
package com.it.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order_sum implements Serializable {
    private String order_id;      //订单ID
    private Double proceeds;        //实收款项(订单总价)
    private String cus_id;     //客户ID
    private Date pay_time;      //付款时间
    private String place_of_receipt;        //收货地址
    private String distribution_mode;       //配送方式
    private Double freight;     //订单运费
    private String order_status;        //订单状态（未确认，已确认、未发货、未收款、已收款）
    private String order_type;      //订单类型（订单，退单）
    private Integer is_done;        //订单是否完结（完成是1，未完成是0）
    private String original_id;     //原订单ID

    private List<Order_details> order_detailsList;      //一个订单对应多个订单明细

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Double getProceeds() {
        return proceeds;
    }

    public void setProceeds(Double proceeds) {
        this.proceeds = proceeds;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public String getPlace_of_receipt() {
        return place_of_receipt;
    }

    public void setPlace_of_receipt(String place_of_receipt) {
        this.place_of_receipt = place_of_receipt;
    }

    public String getDistribution_mode() {
        return distribution_mode;
    }

    public void setDistribution_mode(String distribution_mode) {
        this.distribution_mode = distribution_mode;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public Integer getIs_done() {
        return is_done;
    }

    public void setIs_done(Integer is_done) {
        this.is_done = is_done;
    }

    public String getOriginal_id() {
        return original_id;
    }

    public void setOriginal_id(String original_id) {
        this.original_id = original_id;
    }

    public List<Order_details> getOrder_detailsList() {
        return order_detailsList;
    }

    public void setOrder_detailsList(List<Order_details> order_detailsList) {
        this.order_detailsList = order_detailsList;
    }

    @Override
    public String toString() {
        return "Order_sum{" +
                "order_id='" + order_id + '\'' +
                ", proceeds=" + proceeds +
                ", cus_id='" + cus_id + '\'' +
                ", pay_time=" + pay_time +
                ", place_of_receipt='" + place_of_receipt + '\'' +
                ", distribution_mode='" + distribution_mode + '\'' +
                ", freight=" + freight +
                ", order_status='" + order_status + '\'' +
                ", order_type='" + order_type + '\'' +
                ", is_done=" + is_done +
                ", original_id='" + original_id + '\'' +
                ", order_detailsList=" + order_detailsList +
                '}';
    }
}
