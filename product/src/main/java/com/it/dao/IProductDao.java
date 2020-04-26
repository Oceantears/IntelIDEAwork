package com.it.dao;/*
@author Laotian
@create 2020-03-13-10:50
*/

import com.it.domain.Farmers;
import com.it.domain.Pro_farmer;
import com.it.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {
    //查询所有带分页
    @Select("select *,farmers.farmers_name,farmers.farmers_addr " +
            "from product left join farmers on product.farmers_id=farmers.farmers_id " +
            "where 1=1 and product.product_name like '%${pro_farmer.product_name}%' " +
            "limit #{startPos},#{pageSize}")
    List<Pro_farmer> queryAll(@Param("pro_farmer") Pro_farmer pro_farmer, @Param(value = "startPos") Integer startPos,
							  @Param(value = "pageSize") Integer pageSize);

    //查询总记录数
    @Select("select count(1) from product")
    int count(Pro_farmer pro_farmer);

    //保存信息
    @Insert("insert into product(product_id,farmers_id,product_name,unit,unit_price," +
            "introduce,image_path,product_gross,specification) values(#{product_id}," +
            "(select farmers_id from farmers where farmers_name=#{farmers_name})," +
            "#{product_name},#{unit},#{unit_price},#{introduce},#{image_path}," +
            "#{product_gross},#{specification})")
    void saveProduct(Pro_farmer pro_farmer);
    //更新信息
    @Update("update product set farmers_id=(select farmers_id from farmers where " +
            "farmers_name=#{farmers_name}),product_name=#{product_name}," +
            "unit=#{unit},unit_price=#{unit_price},introduce=#{introduce}," +
            "image_path=#{image_path},product_gross=#{product_gross}," +
            "specification=#{specification} where product_id=#{product_id}")
    void updateProduct(Pro_farmer pro_farmer);
    //根据id删除
    @Delete("delete from product where product_id=#{product_id}")
    void deleteProduct(Product product);

    /**
     * 批量删除
     * @param delIds
     * @return
     */
    @Delete("delete from product where product_id in (${delIds})")
    int productDelete(@Param("delIds") String delIds);
}
