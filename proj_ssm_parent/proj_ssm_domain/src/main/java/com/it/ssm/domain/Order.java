package com.it.ssm.domain;
/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/12 10:05
 * @description：订单表
 * @modified By：
 * @version:     $
 */
 
public class Order {

        private Long id;
        private String orderNum;
        private String orderTime;
        private Integer peopleCount;
        private String orderDesc;
        private Integer payType;
        private Integer orderStatus;
    /**
     * 一个订单属于哪个产品
     */
      private Product product;
      @Override
       public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", orderStatus=" + orderStatus +
                ", product=" + product +
                '}';
    }

    public Order() {
    }

    public Order(Long id, String orderNum, String orderTime, Integer peopleCount, String orderDesc, Integer payType, Integer orderStatus, Product product) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.peopleCount = peopleCount;
        this.orderDesc = orderDesc;
        this.payType = payType;
        this.orderStatus = orderStatus;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }



    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }





}
