package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.SelectResult;

/**
 * @Author njy
 * @Date 2022/4/21 10:37
 */
public interface SelectService {
    CommonResult getAll();

    CommonResult addSelect(SelectResult selectResult);

    CommonResult findByStudentId(int student_id);

    CommonResult findByCourseId(int course_arrange_id);

    CommonResult delete();
}
