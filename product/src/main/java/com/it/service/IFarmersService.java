package com.it.service;/*
@author Laotian
@create 2020-03-13-9:47
*/

import com.it.domain.Farmers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 农户业务接口
 */
public interface IFarmersService {
    //查询所有并分页
    List<Farmers> queryAll(Farmers farmers, Integer startPos, Integer pageSize);
    //查询从记录数
    int count(Farmers farmers);
    //保存信息
    void saveFarmers(Farmers farmers);
    //更新
    void updateFarmers(Farmers farmers);
    //根据id删除
    void deleteFarmer(Farmers farmers);

    /**
     * 批量删除
     * @param delIds
     * @return
     */
    int farmersDelete(@Param("ids") String delIds);
}
