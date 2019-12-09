package com.it.ssm.service;

import com.it.ssm.domain.Role;

import java.util.List;

/**
 *
 */
public interface RoleService {
 List<Role> findAll();

    void save(Role role);

    /**
     * 根据id查询角色
     * @param roleId
     * @return
     */
    Role findById(Long roleId);

    /**
     *  添加权限到角色
     *      * @param roleId  当前用户的角色id
     *      * @param ids  当前角色对应的权限id

     */
    void addPermissionsToRole(Long roleId, Long[] ids);
}
