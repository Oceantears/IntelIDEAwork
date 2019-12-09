package com.gyq.dao;

import java.sql.SQLException;
import java.util.List;


import com.jdbcutils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gyq.bean.PageBean;
import com.gyq.bean.posinformation;

import com.jdbcutils.JdbcUtils;



public class Postdaoimpl implements IPostdao {
	QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
	
	
//���
	@Override
	public boolean add(posinformation post) {
		
  //��дsql���
		String sql="insert into posinforation values(?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Object[]parame= {post.getKs_no(),post.getJob_no(),post.getJob_title(),post.getJob_description(),post.getJob_duenum(),post.getJob_realitynum(),post.getShortage_num(),post.getJob_preparation()};
		
		 
		try {
			int i=quer.update(sql, parame);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("���ʧ��!!");
		}/*finally{
			try {
				JdbcUtils.basicDataSource.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
	}
//ɾ��
	@Override
	public boolean del(posinformation post) {
		QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
		  //��дsql���
				String sql="delete from posinformation where job_no=?";
				System.out.println(sql);
				Object[]parame={post.getJob_no()};
				try {
					int i=quer.update(sql, parame);
					return i>0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("ɾ��ʧ��!!");
				}/*finally{
					try {
						JdbcUtils.basicDataSource.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/

	}
//�޸�
	@Override
	public boolean update(posinformation post) {
		QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
		
		
		  //��дsql���
				String sql="UPDATE posinformation\r\n" + 
						"SET job_no =?,\r\n" + 
						"  ks_no = ?,\r\n" + 
						"  job_title = ?,\r\n" + 
						"  job_description = ?,\r\n" + 
						"  job_duenum = ?,\r\n" + 
						"  job_realitynum =?,\r\n" + 
						"  shortage_num = ?,\r\n" + 
						"  job_preparation = ?\r\n" + 
						"WHERE job_no = ?";
				
				System.out.println(sql);
				Object[] parame={post.getJob_no(),post.getKs_no(),post.getJob_title(),post.getJob_description(),post.getJob_duenum(),post.getJob_realitynum(),post.getShortage_num(),post.getJob_preparation(),post.getJob_no()};
				try {
					int in = quer.update(sql, parame);
					return in > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�޸�ʧ��!!");
				}

	}
//��ѯȫ��
	@Override
	public  List<posinformation>selectall() {
		QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
		  //��дsql���
				String sql="SELECT * FROM posinformation ";
				System.out.println(sql);
				List<posinformation>list=null;
				try {
				list=quer.query(sql, new BeanListHandler<posinformation>(posinformation.class));
					
					/*System.out.println("����"+list.size());
					for (Object[] objects : list) {
						for (Object object : objects) {
							 System.out.print(object+"\t");
						}
						System.out.println();
					}*/
				
				System.out.println("dao-->"+list.size());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}/*finally{
					try {
						JdbcUtils.basicDataSource.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}*/
				
				return list;
				
				
	}



//ģ����ѯ
	@Override
	public List<posinformation> mohu(posinformation post) {
		
		QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
		  //��дsql���
		StringBuffer sql=new StringBuffer();
		
		sql.append("select * from posinformation where 1=1");
		
		//�ж�name��Ϊ��
		if(post.getKs_no()!=null && post.getJob_no()!=null){
			if(!" ".equals(post.getKs_no())&&post.getKs_no()!=null){
				//2.ƴ��sql
				sql.append(" and ks_no like '%"+post.getKs_no()+"%' ");
				
			}
			if(!" ".equals(post.getJob_no())&&post.getJob_no()!=null){
				//2.ƴ��sql
				sql.append(" and job_no like '%"+post.getJob_no()+"%' ");
				
			}
		}
		      List<posinformation>list=null;
				try {
					
					
					
					
	               list=quer.query(sql.toString(), new BeanListHandler<posinformation>(posinformation.class));
					   /*for (Student student : list) {
						System.out.println(student);
					}*/
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}/*finally{
					try {
						JdbcUtils.basicDataSource.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}*/
				
		            
					return list;
	}
//��ҳ��ѯȫ��
	@Override
	 public List<posinformation> queryAllPost(PageBean pageBean, posinformation postinformation) {
		 //��дsql
		StringBuffer sql = new StringBuffer("select * from posinformation where 1=1 ");
		if(postinformation!=null){
			//�ж��˻������ı���ĺϷ���
			// "" null�ж�
			if(!"".equals(postinformation.getJob_no()) && postinformation.getJob_no()!=null) {
				
				//ƴ��sql
				sql.append("and job_no like '%"+postinformation.getJob_no()+"%' ");
				
			}
			
			if(!"".equals(postinformation.getKs_no()) && postinformation.getKs_no()!=null) {
				sql.append(" and Ks_no like '%"+postinformation.getKs_no()+"%'");
				
			}
		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getRows());
		}
		
		System.out.println("sql-->"+sql);
		//�������Users��Ϣ
		List<posinformation> listU = null;
		try {
			
			listU = quer.query(sql.toString(), new BeanListHandler<>(posinformation.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��!");
		}
		
		return listU;
	}

	/**
	 * ��ѯ��¼����
	 * @param user
	 * @return
	 */
	public int postCount(posinformation postformation){
		StringBuffer sb = new StringBuffer("select count(*) from posinformation where 1=1 ");
		//�������ж�����������ƴ��sql
		if(postformation!=null){
			//�ж��˻������ı���ĺϷ���
			// "" null�ж�
			if(!"".equals(postformation.getJob_no()) && postformation.getJob_no()!=null) {
				
				//ƴ��sb 
				sb .append("and job_no like '%"+postformation.getJob_no()+"%' ");
				
			}
			
			if(!"".equals(postformation.getKs_no()) && postformation.getKs_no()!=null) {
				sb .append(" and ks_no like '%"+postformation.getKs_no()+"%'");
				
			}
		}
		 Number num;
		try {
			num = (Number)quer.query(sb.toString(),new ScalarHandler<>());
		
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��!");
		}
		
		
		 
	}
	
	@Override
	public posinformation select(posinformation post) {
		QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
		  //��дsql���
				String sql="SELECT * FROM posinformation WHERE job_no=?";
				System.out.println(sql);
				Object[]parame={post.getJob_no()};
				posinformation list=null;	
				try {
					
	            list =quer.query(sql, new BeanHandler<posinformation>(posinformation.class),parame);
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}/*finally{
					try {
						JdbcUtils.basicDataSource.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}*/
				
		return list;
	}
	
	/**
	 * ɾ��������¼
	 * @param delIds
	 * @return
	 */
	public int postDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  posinformation where job_no in (" + delIds + ")";
		System.out.println("delids--->"+delIds);
		 System.out.println("sql--->"+sql);
		try {
			return quer.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

	
}
