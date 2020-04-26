package com.it.service;/*
@author Laotian
@create 2020-03-13-10:55
*/

import com.it.domain.Farmers;
import com.it.domain.Pro_farmer;
import com.it.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductService {
    //查询所有带分页
    List<Pro_farmer> queryAll(Pro_farmer pro_farmer, Integer startPos, Integer pageSize);

    //查询总记录数
    int count(Pro_farmer pro_farmer);

    //保存信息
    void saveProduct(Pro_farmer pro_farmer);
    //更新
    void updateProduct(Pro_farmer pro_farmer);
    //根据id删除
    void deleteProduct(Product product);

    /**
     * 批量删除
     * @param delIds
     * @return
     */
    int productDelete(@Param("delIds") String delIds);
}
