package com.it.ssm.service.impl;

import com.it.ssm.dao.OrderDAO;
import com.it.ssm.domain.Order;
import com.it.ssm.domain.PageBean;
import com.it.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/12 10:14
 * @description：
 * @modified By：
 * @version:     $
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public void save(Order order) {
        orderDAO.save(order);
    }

    @Override
    public PageBean<Order> findByPage(Integer currPage, Integer pageSize) {
        PageBean<Order>  orderPageBean = new PageBean<>();
        //    当前页 --- 页面传参
        orderPageBean.setCurrPage(currPage);
        //每页大小
        orderPageBean.setPageSize(pageSize);
        Long totalCount = orderDAO.findTotalCount();
        orderPageBean.setTotalCount(totalCount);
        //    总页数 -- 计算
        // Math.ceil(totalCount * 1.0 / pageSize)
        orderPageBean.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
        Integer startIndex = pageSize*(currPage-1) ;  //mysql
        List<Order> orderList = orderDAO.findByPage(startIndex,pageSize);
        orderPageBean.setList(orderList);
        return orderPageBean;
    }
}
