package com.gyq.dao;

import java.util.List;

import com.gyq.bean.PageBean;
import com.gyq.bean.keshi;


public interface IKeshidao {
	//��
    public boolean add(keshi ks);
    //ɾ
    public boolean del(keshi ks);
    //��
    public boolean update(keshi ks);
    //��ALL
    public List<keshi> selectall();

  //�鵥��
    public keshi select(keshi ks);
 

/*
 * //��½ public boolean logion(Postinformation post);
 */
  //ģ����ѯ
    public List<keshi> mohu(keshi ks);
    
 //����ҳ��ѯ����
    public List<keshi> queryAllKs(PageBean pageBean, keshi keshi); 
//ɾ��������¼
    public int KsDelete(String delksId);
//��ѯ�ܼ�¼��
    public int KsCount(keshi keshi);
}
