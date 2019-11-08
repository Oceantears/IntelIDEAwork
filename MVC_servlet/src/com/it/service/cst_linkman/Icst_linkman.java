/**
 * <一句话功能简述>
 * <cst_linkman类的service接口>
 *
 * @author sunmeng
 * @create 2019/11/6   9:10
 */
package com.it.service.cst_linkman;

import com.it.bean.Cst_linkman;

import java.util.List;

public interface Icst_linkman {
	public void addLinkman(Cst_linkman cst_linkman);
	public void delLinkman(Cst_linkman cst_linkman);
	public void updLinkman(Cst_linkman cst_linkman);
	public Cst_linkman findLinkmanById(Cst_linkman cst_linkman);
	public List<Cst_linkman> queryAllLinkman(Cst_linkman cst_linkman);

}
