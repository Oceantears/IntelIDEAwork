package com.it.service.Impl;/*
@author Laotian
@create 2020-03-13-10:57
*/

import com.it.dao.IFarmersDao;
import com.it.dao.IProductDao;
import com.it.domain.Farmers;
import com.it.domain.Pro_farmer;
import com.it.domain.Product;
import com.it.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Autowired
    private IFarmersDao farmersDao;

    @Override
    public List<Pro_farmer> queryAll(Pro_farmer pro_farmer, Integer startPos, Integer pageSize) {
        return productDao.queryAll(pro_farmer,startPos,pageSize);
    }

    @Override
    public int count(Pro_farmer pro_farmer) {
        return productDao.count(pro_farmer);
    }

    @Override
    public void saveProduct(Pro_farmer pro_farmer) {
        productDao.saveProduct(pro_farmer);
    }

    @Override
    public void updateProduct(Pro_farmer pro_farmer) {
        productDao.updateProduct(pro_farmer);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    @Override
    public int productDelete(String delIds) {
        return productDao.productDelete(delIds);
    }


}
