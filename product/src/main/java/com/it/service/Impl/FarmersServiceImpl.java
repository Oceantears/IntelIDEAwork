package com.it.service.Impl;/*
@author Laotian
@create 2020-03-13-9:50
*/

import com.it.dao.IFarmersDao;
import com.it.domain.Farmers;
import com.it.service.IFarmersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("/farmersService")
public class FarmersServiceImpl implements IFarmersService {

    @Autowired
    private IFarmersDao farmersDao;

    @Override
    public List<Farmers> queryAll(Farmers farmers, Integer startPos, Integer pageSize) {
        return farmersDao.queryAll(farmers,startPos,pageSize);
    }

    @Override
    public int count(Farmers farmers) {
        return farmersDao.count(farmers);
    }

    @Override
    public void saveFarmers(Farmers farmers) {
        farmersDao.saveFarmers(farmers);
    }

    @Override
    public void updateFarmers(Farmers farmers) {
        farmersDao.updateFarmers(farmers);
    }

    @Override
    public void deleteFarmer(Farmers farmers) {
        farmersDao.deleteFarmer(farmers);
    }

    @Override
    public int farmersDelete(String delIds) {
        return farmersDao.farmersDelete(delIds);
    }
}
