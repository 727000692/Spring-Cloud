package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author njy
 * @Date 2022/4/21 10:01
 */
@Component
public class CourseServiceFallback implements CourseService{
    @Override
    public CommonResult findById(int id) {
        return CommonResult.fail(888,"调用失败！");
    }
}
