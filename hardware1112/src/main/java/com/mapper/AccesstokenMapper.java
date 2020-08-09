package com.mapper;

import com.bean.Accesstoken;
import com.bean.Camera;
import com.bean.Qxpre;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AccesstokenMapper {
    //添加
    @Insert("insert into accesstoken(`KEYID`,`AppKey`,`Secret`,`AccessToken`,`LoseTime`,`UseNum`,`GetTime`)values(#{KEYID},#{AppKey},#{Secret},#{AccessToken},#{LoseTime},#{UseNum},#{GetTime})")
    public void insertAccesstoken(Accesstoken acc);
    //修改
    @Update("update accesstoken set AccessToken=#{AccessToken},LoseTime=#{LoseTime},GetTime=#{GetTime} where KEYID=#{KEYID}")
    public void updateAccesstoken(Accesstoken acc);
    //id自增列
    @Select("select (count(*)+1)from accesstoken")
    public Integer idPlusAccesstoken();
    @Select("SELECT  * FROM accesstoken inner join camera WHERE camera.ATKEYID=accesstoken.KEYID AND deviceSerial=#{deviceSerial}")
    List<Accesstoken> select();
    @Select("select * from accesstoken")
    List<Accesstoken> selectAll();


    @Select("SELECT * FROM accesstoken where changjia_id=#{changjia_id}")
    public List<Accesstoken> selectAccesstoken(Integer changjia_id);

    @Select("select * from accesstoken where KEYID=#{KEYID}")
    Accesstoken selectID(Accesstoken acc);

    @Select("select * from accesstoken where KEYID=#{KEYID}")
    Accesstoken selectByID(@Param("KEYID") Integer KEYID);

}
