package com.it.ssm.service;

import com.it.ssm.domain.Permission;

import java.util.List;

/**
 *
 * @author zxy
 */
public interface PermissionService {
    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAll();

    /**
     * 查询所有父权限
     * @return
     */
    List<Permission> findAllParentPermission();

    /**添加权限
     *
     * @param permission
     */
    void save(Permission permission);
}
