/**
 * <一句话功能简述>
 * <p>
 * 订单明细DAO接口
 *
 * @author sunmeng
 * @create 2020/3/16   10:14
 */
package com.it.dao;

import com.it.domain.Farmers;
import com.it.domain.FrontEndOrders;
import com.it.domain.Order_details;
import com.it.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersDao {
	/**
	 * 添加订单（添加时生成订单号）
	 */
	@Insert("insert into order_details values (replace(uuid(),'-',''),#{farmers_id},#{product_id},#{numbers},#{unit_price},#{freight})，#{price},"  +
			 "#{proceeds},#{customer_id},#{pay_time},#{place_of_receipt},#{distribution_mode},#{order_status},#{order_type},#{is_done} ")
	void addOrd_detail(Order_details order_details);

	/**
	 * 删除订单（通过订单号删除）
	 */
	@Delete("delete from order_details where id=#{order_id}")
	void del_detail(@Param("order_id") String order_id);

	/**
	 * 修改订单（通过订单号找到订单，然后修改）
	 */
	@Update("update order_details set farmers_id=#{farmers_id},product_id=#{product_id},numbers=#{numbers},unit_price=#{unit_price},freight=#{freight}，price=#{price},"  +
			"proceeds=#{proceeds},customer_id=#{customer_id},pay_time=#{pay_time},place_of_receipt=#{place_of_receipt},distribution_mode=#{distribution_mode},order_status="  +
			"#{order_status},order_type=#{order_type},is_done=#{is_done}")
	void update_detail(Order_details order_details);

	/**
	 * 查询所有订单信息（包括模糊查询）
	 */
	List<FrontEndOrders> queryAllDetails(FrontEndOrders frontEndOrders);

	/**
	 * 根据订单号查询订单
	 */
	@Select("select * from order_details where id=#{order_id}")
	Order_details findOrderById(@Param("order_id") String order_id);
}
