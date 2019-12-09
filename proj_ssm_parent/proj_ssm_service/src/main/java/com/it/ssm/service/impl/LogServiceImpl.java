package com.it.ssm.service.impl;

import com.it.ssm.dao.SysLogDAO;
import com.it.ssm.domain.SysLog;
import com.it.ssm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/11/7 18:09
 * @description：
 * @modified By：
 * @version:     $
 */

@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    SysLogDAO sysLogDAO;
    @Override
    public  void save(SysLog sysLog){
        sysLogDAO.save(sysLog);
  }

}
