package com.cadre.dao;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.cadre.bean.Cadre;
import com.cadre.bean.PageBean;
import com.cadre.jdbc.JdbcUtils;
public class Dao {
	QueryRunner query = new QueryRunner(JdbcUtils.getDataSource());
	public boolean add(Cadre cadre) {
		String sql = "insert into cadre values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = {cadre.getEmployee_id(), cadre.getName(), cadre.getNationality(),
				cadre.getCur_loca(), cadre.getNation(), cadre.getLoca_of_resid(), cadre.getMari_status(),
				cadre.getHeal_condi(), cadre.getAge(), cadre.getSex(), cadre.getHigh_edu(), cadre.getPoli_lands(),
				cadre.getSchool(), cadre.getProf(), cadre.getCertificate(), cadre.getWork_exper(), cadre.getMemb_fam(),
				cadre.getEnglish(), cadre.getSelf_evalu(), cadre.getHobbies(), cadre.getEntry_time(),
				cadre.getLeave_time(), cadre.getAsse_status(), cadre.getViola_of_discip(), cadre.getAudit_status(),
				cadre.getDeparture(), cadre.getLangu_ability(), cadre.getKs_id(),
				cadre.getAdmin_id(),cadre.getReserveposition()};
		int i = 0;
		try {
			i = query.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i > 0;
	}

	public boolean update(Cadre cadre) {
		String sql = "update cadre set name=?,nationality=?,cur_loca=?,nation=?,loca_of_resid=?,mari_status=?,heal_condi=?,age=?,sex=?,high_edu=?,poli_lands=?,school=?,prof=?,certificate=?,work_exper=?,memb_fam=?,english=?,self_evalu=?,hobbies=?,entry_time=?,leave_time=?,asse_status=?,viola_of_discip=?,audit_status=?,departure=?,langu_ability=?,ks_id=?,admin_id=?,reserveposition=? where employee_id=?";
		Object[] param = {cadre.getName(), cadre.getNationality(),
				cadre.getCur_loca(), cadre.getNation(), cadre.getLoca_of_resid(), cadre.getMari_status(),
				cadre.getHeal_condi(), cadre.getAge(), cadre.getSex(), cadre.getHigh_edu(), cadre.getPoli_lands(),
				cadre.getSchool(), cadre.getProf(), cadre.getCertificate(), cadre.getWork_exper(), cadre.getMemb_fam(),
				cadre.getEnglish(), cadre.getSelf_evalu(), cadre.getHobbies(), cadre.getEntry_time(),
				cadre.getLeave_time(), cadre.getAsse_status(), cadre.getViola_of_discip(), cadre.getAudit_status(),
				cadre.getDeparture(), cadre.getLangu_ability(), cadre.getKs_id(),
				cadre.getAdmin_id(),cadre.getReserveposition(), cadre.getEmployee_id()};
		int i = 0;
		try {
			i = query.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i > 0;
	}
	public boolean del(Cadre cadre) {
		String select="select * from cadre where employee_id=?";
		Object[] param1 = {cadre.getEmployee_id()};
		try {
			Cadre cadre1=query.query(select, new BeanHandler<Cadre>(Cadre.class),param1);
			String in="insert into quit(employee_id,name,sex,age,ks_id,admin_id) values(?,?,?,?,?,?)";
			Object[] param2= {cadre1.getEmployee_id(),cadre1.getName(),cadre1.getSex(),cadre1.getAge(),cadre1.getKs_id(),cadre1.getAdmin_id()};
			query.update(in, param2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		String sql = "delete from cadre where employee_id=?";
		Object[] param = { cadre.getEmployee_id() };
		int i = 0;
		try {
			i = query.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i > 0;
	}
	public int delarray(String delIds) {
		String select="select * from cadre where employee_id in (" + delIds + ")";
		try {
			List<Cadre> list=query.query(select,new BeanListHandler<Cadre>(Cadre.class));
			for (Cadre cadre : list) {
				String in="insert into quit(employee_id,name,sex,age,ks_id,admin_id) values(?,?,?,?,?,?)";
				Object[] param2= {cadre.getEmployee_id(),cadre.getName(),cadre.getSex(),cadre.getAge(),cadre.getKs_id(),cadre.getAdmin_id()};
				query.update(in, param2);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "delete from  cadre where employee_id in (" + delIds + ")";
		try {
			return query.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Cadre findbyid(Cadre cadre) {
		String sql = "select * from cadre where employee_id=?";
		Object[] param = { cadre.getEmployee_id() };
		Cadre cadre2 = null;
		try {
			cadre2 = query.query(sql, new BeanHandler<Cadre>(Cadre.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadre2;
	}
	public List<Cadre> query(PageBean pageBean, Cadre cadre) {
		StringBuffer sql = new StringBuffer("select * from cadre where 1=1 ");
		if (cadre != null) {
			if (!"".equals(cadre.getEmployee_id()) && cadre.getEmployee_id() != null) {
				sql.append("and employee_id like '%" + cadre.getEmployee_id() + "%' ");
			}
			if (!"".equals(cadre.getName()) && cadre.getName() != null) {
				sql.append(" and name like '%" + cadre.getName() + "%'");
			}
		}
		if (pageBean != null){
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		System.out.println("sql-->"+sql);
		List<Cadre> list = null;
		try {
			list = query.query(sql.toString(), new BeanListHandler<>(Cadre.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		return list;
	}

	public int Count(Cadre cadre) {
		StringBuffer sb = new StringBuffer("select count(*) from cadre where 1=1 ");
		if (cadre != null) {
			if (!"".equals(cadre.getEmployee_id()) && cadre.getEmployee_id() != null) {
				sb.append("and employee_id like '%" + cadre.getEmployee_id() + "%' ");
			}
			if (!"".equals(cadre.getName()) && cadre.getName() != null) {
				sb.append(" and name like '%" + cadre.getName() + "%'");
			}
		}
		Number num;
		try {
			num = (Number) query.query(sb.toString(), new ScalarHandler<>());
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
	}
	public boolean update2(Cadre cadre) {
		String sql = "update cadre set work_exper=?,reserveposition=? where employee_id=?";
		Object[] param = { cadre.getWork_exper(), cadre.getReserveposition(),
				 cadre.getEmployee_id()};
		int i = 0;
		try {
			i = query.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i > 0;
	}
}
