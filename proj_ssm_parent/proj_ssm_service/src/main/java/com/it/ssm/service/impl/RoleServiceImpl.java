package com.it.ssm.service.impl;

import com.it.ssm.dao.RoleDAO;
import com.it.ssm.domain.Role;
import com.it.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/27 17:16
 * @description：
 * @modified By：
 * @version:     $
 */
 @Service("roleService")
public class RoleServiceImpl implements RoleService {
     @Autowired
     RoleDAO roleDAO;
    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    public Role findById(Long roleId) {
        return roleDAO.findById(roleId);
    }

    @Override
    public void addPermissionsToRole(Long roleId, Long[] ids) {
        //删除之前所有的权限
        roleDAO.deletePermissionsFromRole(roleId);
        //维护新的权限
        if(ids!=null){
            for (Long permissionId:ids
                 ) {
                roleDAO.addPermissionsToRole(roleId,permissionId);
            }
        }
    }
}
