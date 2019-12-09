/**
 * <һ�仰���ܼ���>
 * <��¼ȷ��>
 *
 * @author sunmeng
 * @create 2019/11/28   22:22
 */
package com.sun.dao.imp;

import com.cadre.bean.Cadre;
import com.jdbcutils.JdbcUtils;
import com.sun.dao.IUserConfirmDAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserConfirmDAO_imp implements IUserConfirmDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	@Override
	public Cadre confirmEmp(int userId, String userName) {
		String sql="select * from cadre where employee_id=? and name=?";
		Object[] params={userId,userName};
		Cadre cadre=null;
		try {
			cadre=queryRunner.query(sql,new BeanHandler<>(Cadre.class),params);
			if(cadre!=null){
				System.out.println("��½��֤�ɹ�����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��¼��֤ʧ��!!");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cadre;
	}
}
