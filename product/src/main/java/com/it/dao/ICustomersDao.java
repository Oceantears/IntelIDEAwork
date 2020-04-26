/**
 * <一句话功能简述>
 * <p>
 * 客户表dao阶层
 *
 * @author sunmeng
 * @create 2020/3/16   16:33
 */
package com.it.dao;


import com.it.domain.Customer;
import com.it.domain.Order_sum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("customersDao")
//该注解是告诉Spring，让Spring创建一个名字叫“userDao”的UserDaoImpl实例。
// 当Service需要使用Spring创建的名字叫“userDao”的UserDaoImpl实例时，就可以使用@Resource(name = "userDao")注解告诉Spring，Spring把创建好的userDao注入给Service即可。
public interface ICustomersDao {
	//查询所有客户
	@Select("select * from customer where 1=1 and id = (select customer_id from order_sum where id = #{order_sum.id}) ")
	Set<Customer> queryAllCustoms(Order_sum order_sum);     //也可以用@Param("order_sum")起别名表示
}
