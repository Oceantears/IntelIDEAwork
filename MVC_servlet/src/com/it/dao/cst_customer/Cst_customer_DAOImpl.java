/**
 * <一句话功能简述>
 *
 * <cst_customer类的DAO实现类>
 *
 * @author sunmeng
 * @create 2019/11/6   0:47
 */
package com.it.dao.cst_customer;

import com.it.bean.Cst_customer;
import com.it.bean.Cst_linkman;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Cst_customer_DAOImpl implements Icst_customer_DAO {
	QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public void addCustomer(Cst_customer cst_customer) {
		String sql="insert into cst_customer (cust_name,cust_source,cust_industry,cust_level,cust_phone,cust_mobile) values (?,?,?,?,?,?)";
		Object[] params={cst_customer.getCust_name(),cst_customer.getCust_source(),cst_customer.getCust_industry(),cst_customer.getCust_level(),
				cst_customer.getCust_phone(),cst_customer.getCust_mobile()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("=========客户添加成功==============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("客户添加失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delCustomer(Cst_customer cst_customer) {
		String sql="delete from cst_customer where cust_id=?";     //删除客户表信息
		Object[] params={cst_customer.getCust_id()};
		try {
			int result1=queryRunner.update(sql,params);
			if(result1>0){
				System.out.println("=============客户删除成功=================>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("客户删除失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updCustomer(Cst_customer cst_customer) {
		String sql="update cst_customer set cust_name=?,cust_source=?,cust_industry=?,cust_level=?,cust_phone=?,cust_mobile=?";
		Object[] params={cst_customer.getCust_name(),cst_customer.getCust_source(),cst_customer.getCust_industry(),cst_customer.getCust_level(),
		cst_customer.getCust_phone(),cst_customer.getCust_mobile()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("==================客户修改成功================>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("客户修改失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Cst_customer findCustomerById(Cst_customer cst_customer) {
		String sql="select * from cst_customer where cust_id=?";
		Object[] params={cst_customer.getCust_id()};
		Cst_customer customer=null;
		try {
			cst_customer=queryRunner.query(sql,new BeanHandler<>(Cst_customer.class),params);
			if(cst_customer!=null){
				System.out.println("=================单个客户查询成功==================>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("单个客户查询失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}

	@Override
	public List<Cst_customer> queryAllCustomer(Cst_customer cst_customer) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from cust_customer where 1=1 ");
		if(cst_customer!=null){
			if(!"".equals(cst_customer.getCust_name())){
				sql.append("and cust_name like '%"+cst_customer.getCust_name()+"%'");
			}
		}
		List<Cst_customer> customers=null;
		try {
			customers=queryRunner.query(sql.toString(),new BeanListHandler<Cst_customer>(Cst_customer.class));
			if(customers!=null){
				System.out.println("============客户查询成功===============>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("客户查询失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customers;
	}
}
