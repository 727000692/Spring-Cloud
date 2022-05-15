package com.example.prac01.service;

import com.example.prac01.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author njy
 * @Date 2022/3/21 1:55 下午
 */
public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @param model
     * @return
     */
    public int login(String username, String password, HttpSession session, Model model);

    /**
     * 注册
     * @param user
     * @param model
     */
    public void register(User user, Model model);

    /**
     * 查看所有用户信息
     * @return
     */
    public List<User> queryAll();


    /**
     * 重置用户密码
     * @param id
     * @return
     */
    public int fixPwd(int id);

    /**
     * 添加用户
     * @param user
     * @param model
     */
    public void add(User user, Model model);

}
