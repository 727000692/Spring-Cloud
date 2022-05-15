package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.User;

/**
 * @Author njy
 * @Date 2022/4/18 15:10
 */
public interface UserService {
    CommonResult register(User user);

    CommonResult login(User user);

    CommonResult findById(int id);

    void logout(String token);
}
