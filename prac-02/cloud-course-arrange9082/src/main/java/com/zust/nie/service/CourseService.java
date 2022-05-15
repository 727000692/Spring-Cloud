package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author njy
 * @Date 2022/4/21 09:59
 */
@FeignClient(value = "${provider.name}",fallback = CourseServiceFallback.class)
public interface CourseService {

    //获取某个course
    @GetMapping("/course/find")
    public CommonResult findById(@RequestParam("id") int id);


}
