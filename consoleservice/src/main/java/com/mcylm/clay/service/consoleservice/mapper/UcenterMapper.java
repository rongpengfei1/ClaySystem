package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Mapper
public interface UcenterMapper{

    @Select("select * from console_common_ucenter order by id limit #{page.cPage},#{page.pageSize}")
    List<Ucenter> getList(@Param("page") Page page,Map<String, Object> map);

    @Select("select * from console_common_ucenter where id like #{content} order by id ")
    List<Ucenter> getIDList(@Param("content") String content);

    @Select("select * from console_common_ucenter where username like #{content} order by id ")
    List<Ucenter> getUsernameList(@Param("content") String content);

    @Select("select * from console_common_ucenter where phone like #{content} order by id ")
    List<Ucenter> getPhoneList(@Param("content") String content);

    @Insert("insert into console_common_ucenter(uuid,username,phone,password,createTime,permission,bindUser) values(#{uuid},#{username},#{phone},#{password},#{createTime},#{permission},#{bindUser})")
    void ucenteradd(Ucenter ucenter);

    @Delete("delete from console_common_ucenter where id=#{id}")
    void ucenterdel(Integer id);

    @Update("update console_common_ucenter set username=#{username} where id = #{id}")
    void doUpdateUcenter(@Param("username") String username, @Param("id") Integer id);

    @Update("update console_common_ucenter set phone=#{phone} where id = #{id}")
    void doUpdateUcenterPhone(@Param("phone") String phone, @Param("id") Integer id);

    @Update("update console_common_ucenter set password=#{password} where id = #{id}")
    void doUpdatePassword(@Param("password") String password, @Param("id")Integer id);

    @Select("select count(*) from console_common_ucenter")
    int getCount();

    @Select("select count(*) from console_common_ucenter where id like #{content}")
    int getIDCount(String content);

    @Select("select count(*) from console_common_ucenter where username like #{content}")
    int getUsernameCount(String content);

    @Select("select count(*) from console_common_ucenter where phone like #{content}")
    int getPhoneCount(String content);

}