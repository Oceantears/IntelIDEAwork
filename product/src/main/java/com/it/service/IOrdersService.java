/**
 * <一句话功能简述>
 * <p>
 * 订单明细service接口
 *
 * @author sunmeng
 * @create 2020/3/16   10:11
 */
package com.it.service;

import com.it.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrdersService {
	/**
	 * 添加订单
	 */
	void addOrd_detail(Order_details order_details);

	/**
	 * 删除订单
	 */
	void del_detail(String order_id);

	/**
	 * 修改订单
	 */
	void update_detail(Order_details order_details);

	/**
	 * 查询所有订单
	 */
	List<FrontEndOrders> queryAllDetails(FrontEndOrders frontEndOrders);

	/**
	 * 根据订单号查询订单
	 */
	Order_details findOrderById(String order_id);
}
