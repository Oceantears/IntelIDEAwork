/**
 * <一句话功能简述>
 * <cst_customer类的DAO接口>
 *
 * @author sunmeng
 * @create 2019/11/6   9:15
 */
package com.it.dao.cst_customer;

import com.it.bean.Cst_customer;

import java.util.List;

public interface Icst_customer_DAO {
	public void addCustomer(Cst_customer cst_customer);
	public void delCustomer(Cst_customer cst_customer);
	public void updCustomer(Cst_customer cst_customer);
	public Cst_customer findCustomerById(Cst_customer cst_customer);
	public List<Cst_customer> queryAllCustomer(Cst_customer cst_customer);
}
