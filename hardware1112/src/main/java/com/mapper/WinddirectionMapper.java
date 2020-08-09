package com.mapper;

import com.bean.Temperature;
import com.bean.Winddirection;
import com.bean.Windspeed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WinddirectionMapper {
    //添加
    @Insert("insert into hw_winddirection(`KEYID`,`SN`,`WINDDIRECTION`,`WI_DATE`)values(#{KEYID},#{SN},#{WINDDIRECTION},#{WI_DATE})")
    public void insertWinddirection(Winddirection win);

    @Select("SELECT * FROM hw_winddirection")
    public List<Winddirection> selectWinddirection();

    //id自增列
    @Select("select (count(*)+1)from hw_winddirection")
    public Integer idPlusWinddirection();
}
