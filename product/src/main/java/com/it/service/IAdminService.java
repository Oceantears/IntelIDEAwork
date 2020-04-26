package com.it.service;/*
@author Laotian
@create 2020-03-10-11:59
*/

import com.it.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理服务接口
 */
public interface IAdminService {
    //查询所有信息
   /* List<Admin> findAllAdmin();*/
    //保存信息
    void saveAdmin(Admin admin);
    //更新信息
    void updateAdmin(Admin admin);
    //根据id删除
    void deleteAdmin(Admin admin);
    //批量删除
    int adminDelete(@Param("delIds") String delIds);
    //根据用户名和密码查找
    Admin findByNameAndPassword(Admin admin);
    //查询所有并分页
    List<Admin> queryAll(Admin admin, Integer startPos, Integer pageSize);
    //查询从记录数
    int count(Admin admin);
}
