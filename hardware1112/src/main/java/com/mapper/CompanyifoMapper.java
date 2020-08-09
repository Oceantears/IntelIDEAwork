package com.mapper;

import com.bean.Camera;
import com.bean.Company_ifo;
import com.bean.Place_info;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CompanyifoMapper {

    @Select("select * from company_ifo ")
    List<Company_ifo> selectAll();

   /* //模糊查询
    @Select("select * from company_ifo where company_name like '%${company_name}%' ")
    public List<Place_info> mohuPlace_info(@Param("company_name") String company_name);*/

    //模糊查询
    @Select("select * from company_ifo where company_ifo.company_name like concat('%',#{company_name},'%')")
    public List<Place_info> mohuCompany_ifo(@Param("company_name") String company_name);

}
