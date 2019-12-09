package com.it.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.ssm.dao.ProductDAO;
import com.it.ssm.domain.PageBean;
import com.it.ssm.domain.Product;
import com.it.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/11 15:00
 * @description：
 * @modified By：
 * @version:     $
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delOne(Long id) {
        productDAO.delOne(id);
    }

    @Override
    public void delMany(Long[] ids) {
       if (ids!=null && ids.length>0){
           for (Long id:
                ids) {
               productDAO.delOne(id);
           }

       }
    }

    @Override
    public PageBean<Product> findByPage(Integer currPage, Integer pageSize) {
        //创建PageBean对象

        PageBean<Product> productPageBean = new PageBean<>();
        //    当前页 --- 页面传参
       // private Integer currPage;
        productPageBean.setCurrPage(currPage);
        //    每页条数 -- 页面传参
      //  private Integer pageSize;
        //    总条数 -- 数据库查询
        productPageBean.setPageSize(pageSize);
      //  private Long totalCount;
        Long totalCount = productDAO.findTotalCount();
        productPageBean.setTotalCount(totalCount);
        //    总页数 -- 计算
        // Math.ceil(totalCount * 1.0 / pageSize)

        productPageBean.setTotalPage((int)Math.ceil(totalCount * 1.0 / pageSize));
       // private Integer totalPage;
        //    当前页数据 -- 数据库查询
     //   private List<T> list;
      //  Integer startIndex = pageSize*(currPage-1) +1; //oracle
        Integer startIndex = pageSize*(currPage-1) ;  //mysql
        //Integer endIndex = currPage*pageSize;
        System.out.println("---------===========>"+startIndex+"\t"+pageSize);
        List<Product> productList =   productDAO.findByPage(startIndex,pageSize);

        productPageBean.setList(productList);
        return productPageBean;
    }

    @Override
    public PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize) {
          // 指定分页参数
        PageHelper.startPage(currPage,pageSize);
        // 查询全部
        List<Product> productList = productDAO.findAll();

        // 创建PageInfo对象
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        return pageInfo;
    }
}
