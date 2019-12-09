package com.it.ssm.service.impl;

import com.it.ssm.dao.PermissionDAO;
import com.it.ssm.domain.Permission;
import com.it.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/27 19:57
 * @description：
 * @modified By：
 * @version:     $
 */
 @Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDAO permissionDAO;
    @Override
    public List<Permission> findAll() {
        return permissionDAO.findAll();
    }

    @Override
    public List<Permission> findAllParentPermission() {
        return permissionDAO.findAllParentPermission();
    }

    @Override
    public void save(Permission permission) {
        permissionDAO.save(permission);
    }
}
