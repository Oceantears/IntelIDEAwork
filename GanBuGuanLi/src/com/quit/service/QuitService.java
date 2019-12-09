package com.quit.service;
import java.util.List;
import com.quit.bean.PageBean;
import com.quit.bean.Quit;
import com.quit.dao.QuitDao;
public class QuitService {
	QuitDao quitDao=new QuitDao();
	public boolean add(Quit quit) {
		return quitDao.add(quit);
	}
	public boolean update(Quit quit) {
		return quitDao.update(quit);
	}
	public boolean del(Quit quit) {
		return quitDao.del(quit);
	}
	public int delarray(String delIds) {
		return quitDao.delarray(delIds);
	}
	public Quit findbyid(Quit quit) {
		return quitDao.findbyid(quit);
	}
	
	public List<Quit> query(PageBean pageBean, Quit quit) {
		return quitDao.query(pageBean,quit);
	}
	public int Count(Quit quit) {
		return quitDao.Count(quit);
	}
}
