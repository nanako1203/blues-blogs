package com.example.bluesblogs.mapper;

import com.example.bluesblogs.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author nanako
 * @Date 2024/8/14
 * @Description
 */
@Mapper
public interface UserMapper {

    /*
    * 根据用户名查询用户*/
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    /*
    * 注册用户*/
    @Insert("insert into user(username, password, create_time, update_time) values(#{username}, #{md5Password}, now(), now())")
    void register(String username, String md5Password);
}
