/**
 * <一句话功能简述>
 * <cst_linkman类的service实现类>
 *
 * @author sunmeng
 * @create 2019/11/6   8:58
 */
package com.it.service.cst_linkman;

import com.it.bean.Cst_linkman;
import com.it.dao.cst_linkman.Cst_linkman_DAOImpl;
import com.it.dao.cst_linkman.Icst_linkman_DAO;

import java.util.List;

public class Cst_linkmanImpl implements Icst_linkman {
	Icst_linkman_DAO cst_linkman_dao=new Cst_linkman_DAOImpl();
	@Override
	public void addLinkman(Cst_linkman cst_linkman) {
		try {
			cst_linkman_dao.addLinkman(cst_linkman);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delLinkman(Cst_linkman cst_linkman) {
		try {
			cst_linkman_dao.delLinkman(cst_linkman);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updLinkman(Cst_linkman cst_linkman) {
		try {
			cst_linkman_dao.updLinkman(cst_linkman);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cst_linkman findLinkmanById(Cst_linkman cst_linkman) {
		return cst_linkman_dao.findLinkmanById(cst_linkman);
	}

	@Override
	public List<Cst_linkman> queryAllLinkman(Cst_linkman cst_linkman) {
		return cst_linkman_dao.queryAllLinkman(cst_linkman);
	}
}
