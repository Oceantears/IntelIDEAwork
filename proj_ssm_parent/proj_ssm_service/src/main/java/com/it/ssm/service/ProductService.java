package com.it.ssm.service;

import com.github.pagehelper.PageInfo;
import com.it.ssm.domain.PageBean;
import com.it.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询全部
     * @return
     */
    List<Product> findAll();

    /**
     * 添加
     * @param product
     */
    void save(Product product);

    /**
     * 查询单个
     * @param id
     * @return
     */
    Product findById(Long id);

    /**
     *
     * @param product
     */
    void update(Product product);

    /**
     *删除单个
     * @param id
     */
    void delOne(Long id);

    /**
     * 删除多个
     * @param ids
     */
    void delMany(Long[] ids);

    /**
     * 根据分页参数查询PageBean对象
     * @param currPage
     * @param pageSize
     * @return
     */
    PageBean<Product> findByPage(Integer currPage, Integer pageSize);

    PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize);
}
