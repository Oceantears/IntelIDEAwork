/**
 * <一句话功能简述>
 * <cst_customer类的service接口>
 *
 * @author sunmeng
 * @create 2019/11/6   9:11
 */
package com.it.service.cst_customer;

import com.it.bean.Cst_customer;

import java.util.List;

public interface Icst_customer {
	public void addCustomer(Cst_customer cst_customer);
	public void delCustomer(Cst_customer cst_customer);
	public void updCustomer(Cst_customer cst_customer);
	public Cst_customer findCustomerById(Cst_customer cst_customer);
	public List<Cst_customer> queryAllCustomer(Cst_customer cst_customer);
}
