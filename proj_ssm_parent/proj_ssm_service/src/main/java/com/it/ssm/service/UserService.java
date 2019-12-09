package com.it.ssm.service;

        import com.it.ssm.domain.SysUser;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.stereotype.Service;

        import java.util.List;

/**
 * UserDetailsService 提供了一个方法loadUserByUserName
 * 根据用户名获取用户对象
 */

public interface UserService extends UserDetailsService {
    /**
     * 获取所有用户
     * @return
     */
    List<SysUser> findAll();

    void save(SysUser sysUser);

    /**
     * 按照id查询单个用户
     * @param id
     * @return
     */
    SysUser findById(long id);

    void addRolesToUser(Long userId, Long[] ids);
}
