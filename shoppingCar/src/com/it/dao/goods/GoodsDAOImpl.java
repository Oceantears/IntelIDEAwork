/**
 * <一句话功能简述>
 * <商品DAO层的实现类>
 *
 * @author sunmeng
 * @create 2019/11/11   17:35
 */
package com.it.dao.goods;

import com.it.bean.GoodsInfo;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDAOImpl implements IGoodsDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDatasource());
	// 查
	@Override
	public List<GoodsInfo> queryAllGoods(GoodsInfo goods) {
		//编写sql
		String sql = "select * from goodsinfo where 1=1 ";
		/*if(goods!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(goods.getUser_name()) && goods.getUser_name()!=null) {

				//拼接sql
				sql+="and user_name like '%"+users.getUser_name()+"%' ";

			}

			if(!"".equals(new Integer(users.getUser_age())) && users.getUser_age()!=0) {
				sql+=" and user_age like '%"+users.getUser_age()+"%'";

			}
		}*/

		System.out.println("sql-->"+sql);
		//存放所有Users信息
		List<GoodsInfo> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(GoodsInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listU;
	}

	// 查询单个
	@Override
	public GoodsInfo findGoodsById(GoodsInfo goods) {
		//编写sql
		String sql = "select * from goodsInfo where goods_Id=?";
		//2 打印sql
		System.out.println("sql-->"+sql);
		//3 处理参数
		Object params[] = {goods.getGoods_Id()};

		GoodsInfo good = null;
		try {
			good =  queryRunner.query(sql, new BeanHandler<GoodsInfo>(GoodsInfo.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return good;
	}
}
