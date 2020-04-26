package com.it.service.Impl;
/*
@author Laotian
@create 2020-03-10-12:00
*/

import com.it.dao.IAdminDao;
import com.it.domain.Admin;
import com.it.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;
    /*@Override
    public List<Admin> findAllAdmin() {
        return adminDao.findAllAdmin();
    }*/

    @Override
    public void saveAdmin(Admin admin) {
        adminDao.saveAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDao.deleteAdmin(admin);
    }

    @Override
    public int adminDelete(String delIds) {
        return adminDao.adminDelete(delIds);
    }


    @Override
    public Admin findByNameAndPassword(Admin admin) {
        return adminDao.findByNameAndPassword(admin);
    }

    @Override
    public List<Admin> queryAll(Admin admin, Integer startPos, Integer pageSize) {
        return adminDao.queryAll(admin,startPos,pageSize);
    }


    @Override
    public int count(Admin admin) {
        return adminDao.count(admin);
    }


}
