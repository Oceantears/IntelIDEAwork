package com.cadre.service;
import java.sql.SQLException;
import java.util.List;

import com.cadre.bean.Cadre;
import com.cadre.bean.PageBean;
import com.cadre.dao.Dao;
public class Service {
	Dao dao =new Dao();
	public boolean add(Cadre cadre) {
		return dao.add(cadre);
	}
	public boolean update(Cadre cadre) {
		return dao.update(cadre);
	}
	public boolean del(Cadre cadre) {
		return dao.del(cadre);
	}
	public int delarray(String delIds) {
		return dao.delarray(delIds);
	}
	public Cadre findbyid(Cadre cadre) {
		return dao.findbyid(cadre);
	}
	public int Count(Cadre cadre) {
		return dao.Count(cadre);
	}
	public List<Cadre> query(PageBean pageBean, Cadre cadre) {
		return dao.query( pageBean, cadre) ;
	}
	public boolean update2(Cadre cadre) {
		return dao.update2(cadre);
	}
}
