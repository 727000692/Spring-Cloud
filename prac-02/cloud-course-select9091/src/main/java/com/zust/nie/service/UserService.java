package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author njy
 * @Date 2022/4/21 10:55
 */
@FeignClient(value = "${userProvider.name}",fallback = UserServiceFallback.class)
public interface UserService {
    //查询用户
    @GetMapping("/user/find")
    public CommonResult findById(@RequestParam("id") int id);


}
