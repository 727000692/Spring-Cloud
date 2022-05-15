package com.example.prac01.dao;

import com.example.prac01.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/3/21 2:14 下午
 */
@Repository
public interface UserMapper {

    /**
     * 查询对应账号和密码的用户
     * @param username 账号
     * @param password 密码
     * @return 用户信息
     */
    User query(@Param("username") String username,
               @Param("password") String password);


    List<User> queryAll();

    User queryByUsername(String username);

    int addUser(User user);

    int updatePwdById(int id);

    void updateLoginTime(@Param("id")int id,  @Param("format1")String format1);
}
