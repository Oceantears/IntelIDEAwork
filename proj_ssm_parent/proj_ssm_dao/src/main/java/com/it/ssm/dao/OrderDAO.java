package com.it.ssm.dao;

import com.it.ssm.domain.Order;
import com.it.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */
public interface OrderDAO {
    /**
     * 查询全部
     *@Results映射多列
     * @Result映射单列
     * select :完全类名+方法名==mapperId
     *
     *      * Order类中属性product,
     *      * 1 是Product.class类型的对象，
     *      * 2 对应字段名productId，
     *      * 3 该值有com.it.ssm.dao.ProductDAO.findById通过productId可以查询赋值单值
     *      *
     *
     * @return
     *
     */
    @Select("select * from orders ")
    @Results({

            @Result(property = "product",
                    column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.it.ssm.dao.ProductDAO.findById"))
    })

    List<Order> findAll();

    /**
     * 保存订单
     * @param order
     */
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    @Insert("insert into orders (id,orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId) values (#{id},#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    void save(Order order);
    @Select("select count(1) from orders")
    Long findTotalCount();
    @Select("select * from orders limit #{param1},#{param2}")
    List<Order> findByPage(Integer startIndex, Integer pageSize);
}
