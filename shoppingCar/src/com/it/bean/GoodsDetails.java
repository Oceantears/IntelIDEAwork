/**
 * <一句话功能简述>
 * <商品细节类>
 *
 * 商品  GoodsInfo  goodsInfo;
 *
 * 数量   int   count;
 *
 * @author sunmeng
 * @create 2019/11/11   16:58
 */
package com.it.bean;

import java.io.Serializable;

public class GoodsDetails implements Serializable {
	private GoodsInfo goodsInfo;
	private int count;

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public GoodsDetails() {
	}

	public GoodsDetails(GoodsInfo goodsInfo, int count) {
		this.goodsInfo = goodsInfo;
		this.count = count;
	}
}
