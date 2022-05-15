package com.example.prac01.controller;

import com.example.prac01.entity.User;
import com.example.prac01.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * @Author njy
 * @Date 2022/3/21 1:52 下午
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/to_login")
    public String to_login(){
        return "login";
    }

    @GetMapping("/to_register")
    public String to_register(){
        return "register";
    }


    /**
     * 用户登录的请求处理
     */
    @PostMapping("/login")
    public String login(@Param("username") String username,
                        @Param("password") String password,
                        Model model,
                        HttpSession session){
        int login = userService.login(username,password,session,model);
        if (login == 1){
            return "redirect:/equip/by_user";
        }
        if (login == 0){
            return "redirect:/equip/all";
        }
        return "login";
    }

    /**
     * 用户注册请求
     */
    @PostMapping("/register")
    public String register(User user, Model model){
        userService.register(user,model);
        return "login";
    }

    /**
     * 添加用户
     */
    @PostMapping("/add")
    public String add(User user, Model model){
        userService.add(user,model);
        return "redirect:/equip/all";
    }


    /**
     * 用户退出
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "index";
    }

    /**
     * 重置用户密码
     */
    @GetMapping("/fix")
    public String fix(@Param("id") int id){
        userService.fixPwd(id);
        return "redirect:/equip/all";
    }



}
