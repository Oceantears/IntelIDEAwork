/**
 * <一句话功能简述>
 * <订单DAO层接口>
 *
 * @author sunmeng
 * @create 2019/11/11   17:40
 */
package com.it.dao.orders;

import com.it.bean.OrderDetail;
import com.it.bean.OrderForm;
import com.it.bean.OrderTrack;

import java.util.List;

public interface IOrderDAO {
	public boolean addOrders(OrderForm orderform);
	public boolean addOrderDetails(OrderDetail orderDetail);
	public boolean addOrderTrack(OrderTrack orderTrack);
	public List<OrderForm> queryAllOrderForms(OrderForm orderForm);
	public List<OrderDetail> queryAllOrderDetails(OrderDetail orderDetail);
	public List<OrderTrack> queryAllOrderTracks(OrderTrack orderTrack);
}
