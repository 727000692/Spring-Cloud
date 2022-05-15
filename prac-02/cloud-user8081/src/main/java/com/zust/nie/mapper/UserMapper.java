package com.zust.nie.mapper;

import com.zust.nie.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.UUID;

/**
 * @Author njy
 * @Date 2022/4/18 15:17
 */
@Mapper
public interface UserMapper {

    @Select("SELECT count(*) FROM `user` WHERE `login_name` = #{login_name};")
    int findByLoginName(String login_name);

    @Insert("insert into `user` (login_name, password, real_name, type) values (#{login_name},#{password},#{real_name},0);")
    int add(User user);

    @Select("SELECT * FROM `user` WHERE `login_name` = #{login_name} AND `password` = #{password};")
    User login(@Param("login_name") String login_name, @Param("password") String password);

    @Select("SELECT * FROM `user` WHERE `id` = #{id}; ")
    User findById(int id);

    @Insert("insert into `power` (token, user_id, user_type) values (#{token},#{user_id},#{user_type});")
    void putToken(@Param("token") String token, @Param("user_id") int id, @Param("user_type") int type);

    @Delete("DELETE FROM `power` WHERE token = #{token};")
    void logout(String token);
}
