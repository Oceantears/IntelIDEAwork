/**
 * <一句话功能简述>
 * <cst_customer类service接口的实现类>
 *
 * @author sunmeng
 * @create 2019/11/6   8:57
 */
package com.it.service.cst_customer;

import com.it.bean.Cst_customer;
import com.it.dao.cst_customer.Cst_customer_DAOImpl;
import com.it.dao.cst_customer.Icst_customer_DAO;

import java.util.List;

public class Cst_customerImpl implements Icst_customer {
	Icst_customer_DAO customer_dao=new Cst_customer_DAOImpl();
	@Override
	public void addCustomer(Cst_customer cst_customer) {
		try {
			customer_dao.addCustomer(cst_customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delCustomer(Cst_customer cst_customer) {
		try {
			customer_dao.delCustomer(cst_customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updCustomer(Cst_customer cst_customer) {
		try {
			customer_dao.updCustomer(cst_customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cst_customer findCustomerById(Cst_customer cst_customer) {
		return customer_dao.findCustomerById(cst_customer);
	}

	@Override
	public List<Cst_customer> queryAllCustomer(Cst_customer cst_customer) {
		return customer_dao.queryAllCustomer(cst_customer);
	}
}
