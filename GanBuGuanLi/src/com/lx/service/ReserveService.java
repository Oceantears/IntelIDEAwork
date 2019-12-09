package com.lx.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lx.bean.PageBean;
import com.lx.bean.Reserve;
import com.lx.dao.ReserveDAO;
import com.lx.jdbcutils.JdbcUtils;

public class ReserveService {
	ReserveDAO reserveDAO = new ReserveDAO();
	
	
	public boolean add(Reserve reserve) {
		return reserveDAO.add(reserve);
		
	}
	public void addReserve(Reserve reserve) {
		// 1 ±àÐ´sql
		reserveDAO.addReserve(reserve);
	}

	public Reserve findReserveById(Reserve reserve) {
		return reserveDAO.findReserveById(reserve);
	}

	public List<Reserve> queryAllReserve(PageBean pageBean,Reserve reserve) {
		return reserveDAO.queryAllReserve(pageBean, reserve);
	}
	public int ReserveCount(Reserve reserve) {
		return reserveDAO.ReserveCount(reserve);
		
		
	};
	public boolean del(Reserve reserve) {
		return reserveDAO.del(reserve);
	}
	public int ReserveDelete(String delIds) {
		return reserveDAO.ReserveDelete(delIds);
		
	}

	public boolean updateb(Reserve reserve) {
		return reserveDAO.updateb(reserve);		
	}
	
	public List<Reserve> mohu(Reserve reserve) {
		
		return reserveDAO.mohu(reserve);
	}
	
	//²éµ¥¸ö
	
			public Reserve select(Reserve reserve) {
				return reserveDAO.select(reserve);
			}
	
}