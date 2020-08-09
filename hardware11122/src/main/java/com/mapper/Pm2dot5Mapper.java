package com.mapper;

import com.bean.Longitude;
import com.bean.Pm2dot5;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface Pm2dot5Mapper {
    //添加
    @Insert("insert into hw_pm2dot5(`KEYID`,`SN`,`PM2DOT5`,`PM_DATE`)values(#{KEYID},#{SN},#{PM2DOT5},#{PM_DATE})")
    public void insertPm2dot5(Pm2dot5 p);

    @Select("SELECT * FROM hw_pm2dot5")
    public List<Pm2dot5> selectPm2dot5();


    //id自增列
    @Select("select (count(*)+1)from hw_pm2dot5")
    public Integer idPlusPm2dot5();


    //查日期
    @Select("SELECT hw_pm2dot5.PM2DOT5 FROM `hw_pm2dot5` WHERE `PM_DATE` >=#{data1} AND `PM_DATE` <=#{data2} AND SN=#{EQ_SN}")
    List<Integer> selectpm(String data1, String data2, String EQ_SN);


    @Select("SELECT * FROM hw_pm2dot5 where SN=#{SN}")
    public List<Pm2dot5> selectPm2dot5SN(String SN);

}
