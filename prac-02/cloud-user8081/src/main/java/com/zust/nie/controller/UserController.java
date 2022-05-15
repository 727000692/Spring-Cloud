package com.zust.nie.controller;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.User;
import com.zust.nie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author njy
 * @Date 2022/4/18 15:02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //用户注册
    @PostMapping("/register")
    public CommonResult register(User user){
        return userService.register(user);
    }

    //用户登录
    @PostMapping("/login")
    public CommonResult login(User user){
        return userService.login(user);
    }

    //用户退出
    @GetMapping("/logout")
    public void logout(@RequestParam("token") String token){
        userService.logout(token);
    }

    //查询用户
    @GetMapping("/find")
    public CommonResult findById(@RequestParam("id") int id){
        return userService.findById(id);
    }

}
