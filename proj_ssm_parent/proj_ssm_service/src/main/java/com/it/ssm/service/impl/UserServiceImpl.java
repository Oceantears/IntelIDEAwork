package com.it.ssm.service.impl;

import com.it.ssm.dao.UserDAO;
import com.it.ssm.domain.Role;
import com.it.ssm.domain.SysUser;
import com.it.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/17 16:22
 * @description：
 * @modified By：
 * @version:     $
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
      通过用户名得到用户对象
     *      创建用户对象详情返回
     *      * @param username
     *      UserDetails 用户详情
     *      * @return
     *      * @throws UsernameNotFoundException
     *      */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username-->"+username);
         //根据用户名获取用户对象SysUser,同时查询该用户的角色列表
        SysUser sysUser = userDAO.findByName(username);
        if(sysUser!=null){
       /* //创建角色的集合对象 --- 都是假的角色对象
        Collection<GrantedAuthority>   authorities = new ArrayList<>();

       //创建临时的角色对象
        GrantedAuthority  grantedAuthority =  new SimpleGrantedAuthority("ROLE_USER");
       //对象添加到集合中
        authorities.add(grantedAuthority);*/
            Collection<GrantedAuthority>   authorities = new ArrayList<>();

            for (Role role : sysUser.getRoleList()) {
                System.out.println(role.getRoleName());
                //创建真实的角色对象
                GrantedAuthority  grantedAuthority =  new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
                authorities.add(grantedAuthority);
            }

            /**
             * 参数1 ：账户名
             * 参数2： 密码
             * 参数3 ：角色列表对象
             * {noop}不加密
             */
     //   UserDetails userDetails = new User(sysUser.getUsername(),"{noop}"+sysUser.getPassword(),authorities);
            UserDetails userDetails = new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
            return userDetails;
        }
        return null;
    }

    @Override
    public List<SysUser> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(SysUser sysUser) {
        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
        userDAO.save(sysUser);
    }

    @Override
    public SysUser findById(long id) {
        return userDAO.findById(id);
    }

    /**
     * 添加角色列表到用户
     * @param userId
     * @param ids
     */
    @Override
    public void addRolesToUser(Long userId, Long[] ids) {
        //清空该用户拥有的之前所有的角色
         userDAO.delRolesFromUser(userId);
        //维护新角色关系

        //判断数组是否为null
        if(ids!=null){
            for (Long roleId:ids) {
                 userDAO.saveRoleToUser(userId,roleId);
            }
        }

    }
}
