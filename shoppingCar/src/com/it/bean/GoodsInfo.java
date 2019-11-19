/**
 * <一句话功能简述>
 * <商品信息类>
 *
 * 商品编号,商品名称，商品单价
 *
 * @author sunmeng
 * @create 2019/11/11   16:57
 */
package com.it.bean;

import java.io.Serializable;

public class GoodsInfo implements Serializable {
	private String goods_Id;
	private String goods_Name;
	private String goods_Price;

	public GoodsInfo() {
	}

	public GoodsInfo(String goods_Id, String goods_Name, String goods_Price) {
		this.goods_Id = goods_Id;
		this.goods_Name = goods_Name;
		this.goods_Price = goods_Price;
	}

	public String getGoods_Id() {
		return goods_Id;
	}

	public void setGoods_Id(String goods_Id) {
		this.goods_Id = goods_Id;
	}

	public String getGoods_Name() {
		return goods_Name;
	}

	public void setGoods_Name(String goods_Name) {
		this.goods_Name = goods_Name;
	}

	public String getGoods_Price() {
		return goods_Price;
	}

	public void setGoods_Price(String goods_Price) {
		this.goods_Price = goods_Price;
	}

	@Override
	public String toString() {
		return "GoodsInfo{" +
				"goods_Id='" + goods_Id + '\'' +
				", goods_Name='" + goods_Name + '\'' +
				", goods_Price='" + goods_Price + '\'' +
				'}';
	}
}
