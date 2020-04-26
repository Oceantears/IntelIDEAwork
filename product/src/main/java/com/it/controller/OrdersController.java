/**
 * <一句话功能简述>
 * <p>
 * 订单Controller层
 *
 *
 * @author sunmeng
 * @create 2020/3/16   9:15
 */
package com.it.controller;

import com.it.dao.IOrdersDao;
import com.it.domain.Farmers;
import com.it.domain.FrontEndOrders;
import com.it.domain.Order_details;
import com.it.domain.Product;
import com.it.service.IFarmersService;
import com.it.service.IOrdersService;
import com.it.service.IProductService;
import com.it.utils.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需要产品，购买人，产品数量，付款时间，来源，状态 字段
 *  需要product，customer，farmers，order_sum，order_details表数据
 *  模糊查询字段：农户，产品，订单状态
 */
@Controller("ordersController")
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	IOrdersService ordersService;

	@RequestMapping("/queryAllOrders")
	@ResponseBody		//向前端返回对象
	public Map<String,Object> queryAllOrders(FrontEndOrders frontEndOrders){

		List<FrontEndOrders> list=ordersService.queryAllDetails(frontEndOrders);
		for (FrontEndOrders f:list) {
			System.out.println("=====================>"+f);
		}

		Map<String,Object> map=new HashMap<>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",5);
		map.put("data",list);

		// Layui layui=new Layui();
		// layui.returnJson(0,"查询成功",ordersService.queryAllDetails(frontEndOrders));

		return map;
	}

	@RequestMapping("/toqueryAllOrders")
	public String toqueryAllOrders(){
		return "orders/queryAllOrders";
	}


}
