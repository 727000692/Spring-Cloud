package com.zust.nie.service;

import com.zust.nie.mapper.UserMapper;
import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author njy
 * @Date 2022/4/18 15:10
 */
@Service
public class UserServiceImpl implements UserService{

    @Value("${server.port}")
    private String ServerPort;

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonResult register(User user) {
        int res =userMapper.findByLoginName(user.getLogin_name());
        if (res > 0){
            return CommonResult.fail(222,ServerPort+":该账号已被注册！");
        }
        int add = userMapper.add(user);
        if (add > 0){
            return CommonResult.success(ServerPort+":注册成功!",null);
        }
        return CommonResult.fail(222,ServerPort+":注册失败！");
    }

    @Override
    public CommonResult login(User user) {
        User user1 = userMapper.login(user.getLogin_name(),user.getPassword());
        if (user1 == null){
            return CommonResult.fail(111,ServerPort+":用户名或密码错误！");
        }
        int id = user1.getId();
        int type = user1.getType();
        String uuid = UUID.randomUUID().toString();
        userMapper.putToken(uuid,id,type);
        return CommonResult.success(ServerPort+":登录成功！",uuid);
    }

    @Override
    public CommonResult findById(int id) {
        User user = userMapper.findById(id);
        if (user != null){
            return CommonResult.success(ServerPort+":查询成功！",user);
        }
        return CommonResult.fail(404,ServerPort+":没有这个人！");
    }

    @Override
    public void logout(String token) {
        userMapper.logout(token);
    }
}
