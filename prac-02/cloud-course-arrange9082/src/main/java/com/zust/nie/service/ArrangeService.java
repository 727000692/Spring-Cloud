package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.CourseArrange;

/**
 * @Author njy
 * @Date 2022/4/20 23:07
 */
public interface ArrangeService {
    CommonResult get();

    CommonResult findById(int id);

    CommonResult addArrange(CourseArrange courseArrange);

    void select(int id);

    Boolean selected(int id);
}
