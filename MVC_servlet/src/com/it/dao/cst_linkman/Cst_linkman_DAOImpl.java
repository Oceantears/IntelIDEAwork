/**
 * <一句话功能简述>
 * <cst_linkman类的DAO实现类>
 *
 * @author sunmeng
 * @create 2019/11/6   0:46
 */
package com.it.dao.cst_linkman;

import com.it.bean.Cst_linkman;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Cst_linkman_DAOImpl implements Icst_linkman_DAO {
	QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public void addLinkman(Cst_linkman cst_linkman) {
		String sql="insert into cst_linkman (lkm_name,lkm_cust_id,lkm_gender,lkm_phone,lkm_mobile,lkm_email,lkm_qq,lkm_position,lkm_memo) values (?,?,?,?,?,?,?,?,?)";
		Object[] params={cst_linkman.getLkm_name(),cst_linkman.getLkm_cust_id(),cst_linkman.getLkm_gender(),cst_linkman.getLkm_phone(),cst_linkman.getLkm_mobile(),
		cst_linkman.getLkm_email(),cst_linkman.getLkm_qq(),cst_linkman.getLkm_position(),cst_linkman.getLkm_memo()};

		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("=============联系人插入成功=============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("联系人插入失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delLinkman(Cst_linkman cst_linkman) {
		String sql="delete from cst_linkman where lkm_id=?";
		Object[] params={cst_linkman.getLkm_id()};

		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("============联系人删除成功================>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("联系人删除操作失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updLinkman(Cst_linkman cst_linkman) {
		String sql="update cst_linkman set lkm_name=?,lkm_cust_id=?,lkm_gender=?,lkm_phone=?,lkm_mobile=?,lkm_email=?,lkm_qq=?,lkm_position=?lkm_memo=?";
		Object[] params={cst_linkman.getLkm_name(),cst_linkman.getLkm_cust_id(),cst_linkman.getLkm_gender(),cst_linkman.getLkm_phone(),
				cst_linkman.getLkm_mobile(),cst_linkman.getLkm_email(),cst_linkman.getLkm_qq(),cst_linkman.getLkm_position(),cst_linkman.getLkm_memo()};

		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("==============联系人更新成功======================>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("联系人更新失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Cst_linkman findLinkmanById(Cst_linkman cst_linkman) {
		String sql="select * from cst_linkman where lkm_id=?";
		Object[] params={cst_linkman.getLkm_id()};

		Cst_linkman linkman= null;
		try {
			linkman = queryRunner.query(sql,new BeanHandler<>(Cst_linkman.class),params);
			if(linkman!=null){
				System.out.println("================联系人查询成功================>"+linkman);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("联系人查询失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return linkman;
	}

	@Override
	public List<Cst_linkman> queryAllLinkman(Cst_linkman cst_linkman) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from cst_linkman where 1=1 ");
		if(cst_linkman!=null){
			if(!"".equals(cst_linkman.getLkm_name())&&cst_linkman.getLkm_name()!=null){
				sql.append("and lkm_name like '%"+cst_linkman.getLkm_name()+"%'");
			}
		}
		List<Cst_linkman> linkmanList=null;
		try {
			linkmanList=queryRunner.query(sql.toString(),new BeanListHandler<Cst_linkman>(Cst_linkman.class));
			System.out.println("=============联系人整体/模糊查询成功===========>");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("联系人整体查询失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return linkmanList;
	}
}
