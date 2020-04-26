/**
 * <一句话功能简述>
 * <p>
 * 客户service接口
 *
 * @author sunmeng
 * @create 2020/3/16   17:04
 */
package com.it.service;

import com.it.domain.Customer;
import com.it.domain.Order_sum;

import java.util.Set;

public interface ICustomerService {
	Set<Customer> queryAllCustoms(Order_sum order_sum);
}
