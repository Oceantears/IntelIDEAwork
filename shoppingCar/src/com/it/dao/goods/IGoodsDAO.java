/**
 * <һ�仰���ܼ���>
 * <��ƷDAO��ӿ�>
 *
 * @author sunmeng
 * @create 2019/11/11   17:37
 */
package com.it.dao.goods;

import com.it.bean.GoodsInfo;

import java.util.List;

public interface IGoodsDAO {
	public List<GoodsInfo> queryAllGoods(GoodsInfo goods);
	public GoodsInfo findGoodsById(GoodsInfo goods);
}
