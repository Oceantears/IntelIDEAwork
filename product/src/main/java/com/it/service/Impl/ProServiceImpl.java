/**
 *
 */
package com.it.service.Impl;

import com.it.dao.IProDao;
import com.it.domain.Pro_form_info;
import com.it.service.IProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Laotian
 * @date 2020-03-20 10:53
 */

/**
 * 产品组成业务层实现类
 */
@Service("proService")
public class ProServiceImpl implements IProService {

    @Autowired
    private IProDao proDao;


    @Override
    public List<Pro_form_info> queryAllPro(Pro_form_info pro_form_info) {
        return proDao.queryAllPro(pro_form_info);
    }

    @Override
    public void savePro(Pro_form_info pro_form_info) {
        proDao.savePro(pro_form_info);
    }
}