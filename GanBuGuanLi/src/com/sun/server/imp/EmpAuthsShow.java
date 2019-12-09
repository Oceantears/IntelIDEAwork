/**
 * <一句话功能简述>
 * <查询用户ID对应的权限和权限组>>
 *
 * @author sunmeng
 * @create 2019/11/28   22:10
 */
package com.sun.server.imp;

import com.cadre.bean.Cadre;
import com.sun.bean.Auth;
import com.sun.bean.Group_auth;
import com.sun.dao.IauthDAO;
import com.sun.dao.Igroup_authDAO;
import com.sun.dao.imp.AuthDAO_imp;
import com.sun.dao.imp.Group_authDAO_imp;
import com.sun.server.IEmpAuthsShow;

import java.util.List;

public class EmpAuthsShow implements IEmpAuthsShow {
	Cadre cadre=new Cadre();
	Igroup_authDAO group_authDAO=new Group_authDAO_imp();
	IauthDAO authDAO=new AuthDAO_imp();
	@Override
	public List<Group_auth> findGroup(int employee_id) {
		cadre.setEmployee_id(String.valueOf(employee_id));
		return group_authDAO.queryAllGroup(cadre);
	}

	@Override
	public List<Auth> findEmpAuth(int employee_id) {
		cadre.setEmployee_id(String.valueOf(employee_id));
		return authDAO.queryAllAuth(cadre);
	}
}
