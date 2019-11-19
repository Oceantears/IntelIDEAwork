/**
 * <一句话功能简述>
 * <订单表类>
 *
 * @author sunmeng
 * @create 2019/11/11   16:55
 */
package com.it.bean;

public class OrderForm {
	private String ord_id;
	private String user_id;
	private String total;
	private String user_name;

	public OrderForm() {
	}

	public OrderForm(String ord_id, String user_id, String total, String user_name) {
		this.ord_id = ord_id;
		this.user_id = user_id;
		this.total = total;
		this.user_name = user_name;
	}

	public String getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "OrderForm{" +
				"ord_id='" + ord_id + '\'' +
				", user_id='" + user_id + '\'' +
				", total='" + total + '\'' +
				", user_name='" + user_name + '\'' +
				'}';
	}
}
