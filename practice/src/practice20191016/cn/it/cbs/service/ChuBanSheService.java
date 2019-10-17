/**
 * <一句话功能简述>
 * <给ZhangWuService类添加一个类型为ZhangWuDao的成员变量，因为service依赖dao。>
 *
 * @author sunmeng
 * @create 2019/10/16   10:45
 */
package practice20191016.cn.it.cbs.service;

import practice20191016.cn.it.cbs.dao.ChuBanSheDAO;
import practice20191016.com.it.cbs.bean.ChuBanShe;

import java.util.List;

public class ChuBanSheService {
	ChuBanSheDAO chuBanSheDAO=new ChuBanSheDAO();
	public List<ChuBanShe> selectAll(){
		return chuBanSheDAO.selectAll();
	}
	public void updateBook(ChuBanShe chuBanShe){
		chuBanSheDAO.updateBook(chuBanShe);
	}
	public List<ChuBanShe> select(String s){
		return chuBanSheDAO.select(s);
	}
}
