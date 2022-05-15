package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author njy
 * @Date 2022/4/21 10:57
 */
@Component
public class UserServiceFallback implements UserService{
    @Override
    public CommonResult findById(int id) {
        return CommonResult.fail(444,"wrong!");
    }
}
