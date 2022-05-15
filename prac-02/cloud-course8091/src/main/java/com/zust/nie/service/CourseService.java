package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.Course;

/**
 * @Author njy
 * @Date 2022/4/20 22:31
 */
public interface CourseService {
    CommonResult getAll();

    CommonResult add(Course course);

    CommonResult deleteById(int id);

    CommonResult findById(int id);
}
