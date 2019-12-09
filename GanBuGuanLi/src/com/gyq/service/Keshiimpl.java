package com.gyq.service;

import java.util.List;

import com.gyq.bean.PageBean;
import com.gyq.bean.keshi;
import com.gyq.dao.Keshidaoimpl;

public class Keshiimpl implements Ikeshi{
	
	Keshidaoimpl ksdao = new Keshidaoimpl();

	@Override
	public boolean add(keshi ks) {
		// TODO Auto-generated method stub
		return ksdao.add(ks);
	}

	@Override
	public boolean del(keshi ks) {
		// TODO Auto-generated method stub
		return ksdao.del(ks);
	}

	@Override
	public boolean update(keshi ks) {
		// TODO Auto-generated method stub
		return ksdao.update(ks);
	}

	@Override
	public List<keshi> selectall() {
		// TODO Auto-generated method stub
		return ksdao.selectall();
	}

	@Override
	public keshi select(keshi ks) {
		// TODO Auto-generated method stub
		return ksdao.select(ks);
	}

	@Override
	public List<keshi> mohu(keshi ks) {
		// TODO Auto-generated method stub
		return ksdao.mohu(ks);
	}

	@Override
	public List<keshi> queryAllKs(PageBean pageBean, keshi keshi) {
		// TODO Auto-generated method stub
		return ksdao.queryAllKs(pageBean, keshi);
	}

	@Override
	public int KsDelete(String delksId) {
		// TODO Auto-generated method stub
		return ksdao.KsDelete(delksId);
	}

	@Override
	public int KsCount(keshi keshi) {
		// TODO Auto-generated method stub
		return ksdao.KsCount(keshi);
	}

}
