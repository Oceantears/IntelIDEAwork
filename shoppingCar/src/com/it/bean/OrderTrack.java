/**
 * <一句话功能简述>
 * <订单跟踪类>
 *
 * @author sunmeng
 * @create 2019/11/11   16:55
 */
package com.it.bean;

public class OrderTrack {
	private String zz_id;
	private String ord_id;
	private String ord_state;
	private String tm;

	public OrderTrack() {
	}

	public OrderTrack(String zz_id, String ord_id, String ord_state, String tm) {
		this.zz_id = zz_id;
		this.ord_id = ord_id;
		this.ord_state = ord_state;
		this.tm = tm;
	}

	public String getZz_id() {
		return zz_id;
	}

	public void setZz_id(String zz_id) {
		this.zz_id = zz_id;
	}

	public String getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}

	public String getOrd_state() {
		return ord_state;
	}

	public void setOrd_state(String ord_state) {
		this.ord_state = ord_state;
	}

	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}

	@Override
	public String toString() {
		return "OrderTrack{" +
				"zz_id='" + zz_id + '\'' +
				", ord_id='" + ord_id + '\'' +
				", ord_state='" + ord_state + '\'' +
				", tm='" + tm + '\'' +
				'}';
	}
}
