/**
 * <一句话功能简述>
 * <p>
 * 客户Service层实现类
 *
 * @author sunmeng
 * @create 2020/3/16   17:07
 */
package com.it.service.Impl;

import com.it.dao.ICustomersDao;
import com.it.domain.Customer;
import com.it.domain.Order_sum;
import com.it.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomersDao customersDao;

	@Override
	public Set<Customer> queryAllCustoms(Order_sum order_sum) {

		return customersDao.queryAllCustoms(order_sum);
	}
}
