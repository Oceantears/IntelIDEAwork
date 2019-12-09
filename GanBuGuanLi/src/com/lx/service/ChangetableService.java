package com.lx.service;

import java.sql.SQLException;
import java.util.List;

import com.lx.bean.Changetable;
import com.lx.bean.PageBean;
import com.lx.dao.ChangetableDAO;



public class ChangetableService {
	
	ChangetableDAO changetableDAO =new ChangetableDAO();
	public void addchangetable(Changetable changetable) {
		changetableDAO.addChangetable(changetable);
	}

	public Changetable findchangetableById(Changetable changetable) {
		return changetableDAO.findChangetableById(changetable);
	}

	public List<Changetable> queryAllchangetable(PageBean pageBean, Changetable changetable) {
          return changetableDAO.queryAllChangetable(pageBean, changetable);
	}

	public int ChangetableCount(Changetable changetable) {
		return changetableDAO.ChangetableCount(changetable);
	}
	 //删除单个
	public boolean del(Changetable changetable) {
		return changetableDAO.del(changetable);

	}
	public int ChangetableDelete(String delIds) {
		return changetableDAO.ChangetableDelete(delIds);
	}
	// 查单个

	public Changetable select(Changetable changetable) {
		return changetableDAO.select(changetable);
				
	}
	// 模糊查
	public List<Changetable> mohu(Changetable changetable) {
	 return changetableDAO.mohu(changetable);
				
   }
	//改
	public boolean updateb(Changetable changetable) {
		return changetableDAO.updateb(changetable);
	}
	// 增
	public boolean add(Changetable changetable) {
		return changetableDAO.add(changetable);	
				
	}
			
}