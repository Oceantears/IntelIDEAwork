/**
 * <一句话功能简述>
 * <p>
 * 前端展示的订单信息汇总
 *
 * @author sunmeng
 * @create 2020/3/19   11:30
 */
package com.it.domain;

import java.io.Serializable;
import java.util.Date;

public class FrontEndOrders implements Serializable {
	// private Order_details order_details;
	// private Order_sum order_sum;
	// private Farmers farmers;
	// private Product product;
	// private Customer customer;


	//农户信息
	private String farmers_name;
	//产品信息
	private String product_name;
	//订单详细信息
	private String order_id;      //订单ID
	private Double numbers;     //产品数量
	private String pay_time;      //付款时间
	private String order_status;        //订单状态（未确认，已确认、未发货、未收款、已收款）
	private Integer is_done;        //订单是否完结（完成是1，未完成是0）
	//客户信息
	private String cus_name;//客户名称

	public String getFarmers_name() {
		return farmers_name;
	}

	public void setFarmers_name(String farmers_name) {
		this.farmers_name = farmers_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Double getNumbers() {
		return numbers;
	}

	public void setNumbers(Double numbers) {
		this.numbers = numbers;
	}

	public String getPay_time() {
		return pay_time;
	}

	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Integer getIs_done() {
		return is_done;
	}

	public void setIs_done(Integer is_done) {
		this.is_done = is_done;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	@Override
	public String toString() {
		return "FrontEndOrders{" +
				"farmers_name='" + farmers_name + '\'' +
				", product_name='" + product_name + '\'' +
				", order_id='" + order_id + '\'' +
				", numbers=" + numbers +
				", pay_time=" + pay_time +
				", order_status='" + order_status + '\'' +
				", is_done=" + is_done +
				", cus_name='" + cus_name + '\'' +
				'}';
	}
}
