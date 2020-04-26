package com.it.service;

/**
 * @author Laotian
 * @date 2020-03-20 10:51
 */

import com.it.domain.Pro_form_info;

import java.util.List;

/**
 * 产品组成业务层接口
 */
public interface IProService {
    //查询所有
    List<Pro_form_info> queryAllPro(Pro_form_info pro_form_info);

    //添加
    void savePro(Pro_form_info pro_form_info);
}
