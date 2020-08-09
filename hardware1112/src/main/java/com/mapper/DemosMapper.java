package com.mapper;


import com.bean.Airpressure;
import com.bean.Demos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DemosMapper {


    //添加
    @Insert("INSERT INTO hw_demos(`KEYID`,`GETTIEM`,`SN`,`SHIPIN`,`TUPIAN`,`FENGSU`,`FENGXIANG`,`WENDU`,`SHIDU`,`GUANGZHAO`,`YULIANG`,`QIYA`,`PM2DOT5`,`TURANGPH`,`HAIBA`)values(#{KEYID},#{GETTIEM},#{SN},#{SHIPIN},#{TUPIAN},#{FENGSU},#{FENGXIANG},#{WENDU},#{SHIDU},#{GUANGZHAO},#{YULIANG},#{QIYA},#{PM2DOT5},#{TURANGPH},#{HAIBA})")
    public void insertDemos(Demos d);

    //id自增列
    @Select("select (count(*)+1)from hw_demos")
    public Integer idPlusDemos();

    @Select("SELECT * FROM hw_demos where  SN=#{SN}")
    public List<Demos> selecthw_demosSN(String SN);

}
