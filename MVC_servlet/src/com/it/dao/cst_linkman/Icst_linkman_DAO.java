/**
 * <һ�仰���ܼ���>
 * <cst_linkman���DAO�ӿ�>
 *
 * @author sunmeng
 * @create 2019/11/6   9:14
 */
package com.it.dao.cst_linkman;

import com.it.bean.Cst_linkman;

import java.util.List;

public interface Icst_linkman_DAO {
	public void addLinkman(Cst_linkman cst_linkman);
	public void delLinkman(Cst_linkman cst_linkman);
	public void updLinkman(Cst_linkman cst_linkman);
	public Cst_linkman findLinkmanById(Cst_linkman cst_linkman);
	public List<Cst_linkman> queryAllLinkman(Cst_linkman cst_linkman);
}
