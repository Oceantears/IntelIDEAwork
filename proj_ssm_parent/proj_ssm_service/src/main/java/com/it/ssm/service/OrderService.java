package com.it.ssm.service;

import com.it.ssm.domain.Order;
import com.it.ssm.domain.PageBean;

import java.util.List;

/**
 *
 */
public interface OrderService {
    /**
     * 查询所有订单
     * @return
     */
    List<Order> findAll();

    /**
     * 添加订单
     * @param order
     */
    void save(Order order);

    PageBean<Order>  findByPage(Integer currPage, Integer pageSize);
}
