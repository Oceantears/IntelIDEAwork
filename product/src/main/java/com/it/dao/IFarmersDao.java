package com.it.dao;/*
@author Laotian
@create 2020-03-13-9:26
*/

import com.it.domain.Admin;
import com.it.domain.Farmers;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 农户接口
 */
@Repository
public interface IFarmersDao {
    //保存信息
    @Insert("insert into farmers(farmers_id,county,farmers_name,farmers_tel,farmers_addr,qrcode," +
            "addtime,low_income_level,is_cross_level) values(#{farmers_id},#{county},#{farmers_name}," +
            "#{farmers_tel},#{farmers_addr},#{qrcode},#{addtime},#{low_income_level}," +
            "#{is_cross_level})")
    void saveFarmers(Farmers farmers);
    //更新信息
    @Update("update farmers set county=#{county},farmers_name=#{farmers_name}," +
            "  farmers_tel=#{farmers_tel},farmers_addr=#{farmers_addr},qrcode=#{qrcode}," +
            "  addtime=#{addtime},low_income_level=#{low_income_level},is_cross_level=#{is_cross_level}" +
            "   where farmers_id=#{farmers_id}")
    void updateFarmers(Farmers farmers);
    //根据id删除
    @Delete("delete from farmers where farmers_id=#{farmers_id}")
    void deleteFarmer(Farmers farmers);

    /**
     * 批量删除
     * @param delIds
     * @return
     */
    @Delete("delete from farmers where farmers_id in (${delIds})")
    int farmersDelete(@Param("ids") String delIds);

    //根据用户名和密码查找
    /*@Select("select * from admin where name=#{name} and password=#{password}")
    Admin findByNameAndPassword(Admin admin);*/

    @Select("select * from farmers where 1=1 and farmers_name like '%${farmers.farmers_name}%' " +
            "limit #{startPos},#{pageSize}")
    List<Farmers> queryAll(@Param("farmers") Farmers farmers, @Param(value = "startPos") Integer startPos,
						   @Param(value = "pageSize") Integer pageSize);

    @Select("select count(1) from farmers")
    int count(Farmers farmers);
}
