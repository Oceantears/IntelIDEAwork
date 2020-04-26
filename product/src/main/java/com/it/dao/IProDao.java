package com.it.dao;

import com.it.domain.Pro_form_info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Laotian
 * @date 2020-03-20 10:00
 * 产品组成dao接口
 */
@Repository
public interface IProDao {
    //查询所有
    @Select("select * from pro_form_info")
    List<Pro_form_info> queryAllPro(Pro_form_info pro_form_info);

    //添加
    @Insert("insert into pro_form_info(product_id,proj_constitute," +
            "proj_classes,proj_price,percent) values(#{product_id}," +
            "#{proj_constitute},#{proj_price},#{percent})")
    void savePro(Pro_form_info pro_form_info);
}
