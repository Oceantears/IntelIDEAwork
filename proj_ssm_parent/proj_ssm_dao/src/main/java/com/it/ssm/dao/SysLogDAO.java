package com.it.ssm.dao;

import com.it.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface SysLogDAO {
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    @Insert("insert into sys_log(visitTime,username,ip,method) values(#{visitTime},#{username}, #{ip},#{method})")
     void save(SysLog sysLog);
}
