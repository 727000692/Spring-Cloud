package com.example.prac01.service.impl;

import com.example.prac01.dao.UserMapper;
import com.example.prac01.entity.User;
import com.example.prac01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author njy
 * @Date 2022/3/21 2:12 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(String username, String password, HttpSession session, Model model) {
        User query = userMapper.query(username, password);
        if (query == null){
            model.addAttribute("msg","账号或密码错误!");
            return -1;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format1 = format.format(date);
        userMapper.updateLoginTime(query.getId(),format1);
        session.setAttribute("user",query);
        return query.getType();
    }

    @Override
    public void register(User user,Model model) {
        User user1 = userMapper.queryByUsername(user.getUsername());
        if (user1 == null){
            int i = userMapper.addUser(user);
            model.addAttribute("msg","注册成功！");
        }else {
            model.addAttribute("msg","该账户已被注册，注册失败！");
        }
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }



    @Override
    public int fixPwd(int id) {
        return userMapper.updatePwdById(id);
    }

    @Override
    public void add(User user, Model model) {
        User user1 = userMapper.queryByUsername(user.getUsername());
        if (user1 == null){
            int i = userMapper.addUser(user);
        }else {
            model.addAttribute("msg","该账户已被注册，添加失败！");
        }
    }
}
