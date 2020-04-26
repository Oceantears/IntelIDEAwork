/**
 * <一句话功能简述>
 * <p>
 * 订单明细service层实现类
 *
 * @author sunmeng
 * @create 2020/3/16   10:13
 */
package com.it.service.Impl;

import com.it.dao.IOrdersDao;
import com.it.domain.Farmers;
import com.it.domain.FrontEndOrders;
import com.it.domain.Order_details;
import com.it.domain.Product;
import com.it.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderServiceImpl")
public class OrdersServiceImpl implements IOrdersService {
	@Autowired
	private IOrdersDao ordersDao;


	@Override
	public void addOrd_detail(Order_details order_details) {
		ordersDao.addOrd_detail(order_details);
	}

	@Override
	public void del_detail(String order_id) {
		ordersDao.del_detail(order_id);
	}

	@Override
	public void update_detail(Order_details order_details) {
		ordersDao.update_detail(order_details);
	}

	@Override
	public List<FrontEndOrders> queryAllDetails(FrontEndOrders frontEndOrders) {
		return ordersDao.queryAllDetails(frontEndOrders);
	}

	@Override
	public Order_details findOrderById(String order_id) {
		return ordersDao.findOrderById(order_id);
	}
}
