package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author njy
 * @Date 2022/4/21 10:55
 */
@FeignClient(value = "${arrangeProvider.name}",fallback = ArrangeServiceFallback.class)
public interface ArrangeService {

    @GetMapping("/arrange/find")
    public CommonResult findById(@RequestParam("id") int id);

    @GetMapping("/arrange/select")
    public void select(@RequestParam("id") int id);

    @GetMapping("/arrange/selected")
    public Boolean selected(@RequestParam("id") int id);
}
