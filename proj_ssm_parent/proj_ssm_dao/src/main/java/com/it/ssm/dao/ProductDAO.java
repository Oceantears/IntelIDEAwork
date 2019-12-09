package com.it.ssm.dao;

import com.it.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/11 14:58
 * @description：产品dao层
 * @modified By：
 * @version:     $
 */
public interface ProductDAO {
    @Select("select * from product")
    List<Product> findAll();
    //声明是自增列
   /* @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    @Insert("insert into product (id,productNum," +
            "productName,cityName,departureTime," +
            "productPrice,productDesc,productStatus)  " +
            "values (" +
            "#{id}," +
            "#{productNum,jdbcType=VARCHAR}," +
            "#{productName,jdbcType=VARCHAR}," +
            "#{cityName,jdbcType=VARCHAR}," +
            "#{departureTime,jdbcType=VARCHAR}," +
            "#{productPrice,jdbcType=DECIMAL}," +
            "#{productDesc,jdbcType=VARCHAR}," +
            "#{productStatus,jdbcType=INTEGER})")
    void save(Product product);*/
   //自增列从数据库提前获取id的值
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    @Insert("insert into product (id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);


    @Select("select * from product where id=#{id}")
    Product findById(Long id);

   /* @Update("update product set" +
            " productNum=#{productNum}," +
            "productName=#{productName}," +
            "cityName=#{cityName}," +
            "departureTime=#{departureTime}," +
            "productPrice=# {productPrice}," +
            "productDesc=#{productDesc}," +
            "productStatus=#{productStatus} " +
            "where id = #{id}")*/
    @Update("update product set " +
            "productNum=#{productNum,jdbcType=VARCHAR}," +
            "productName=#{productName,jdbcType=VARCHAR}," +
            "cityName=#{cityName,jdbcType=VARCHAR}," +
            "departureTime=#{departureTime,jdbcType=VARCHAR}," +
            "productPrice=#{productPrice,jdbcType=DECIMAL}," +
            "productDesc=#{productDesc,jdbcType=VARCHAR}," +
            "productStatus=#{productStatus,jdbcType=INTEGER}" +
            " where id=#{id}")
    void update(Product product);
    @Delete("delete from product where id=#{id}")
    void delOne(Long id);

    /**
     * 查询总的记录数
     * count(*)效率最低
     * count(主键)唯一，不为null
     * count(1)
     * 常量列效率高
     * @return
     */
    @Select("select count(1) from product")
    Long findTotalCount();
    @Select("select * from product limit #{param1},#{param2}")
     List<Product> findByPage(Integer startIndex, Integer pageSize);
}
