package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.Course;
import com.zust.nie.entities.CourseArrange;
import com.zust.nie.entities.User;
import com.zust.nie.mapper.ArrangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/20 23:13
 */
@Service
public class ArrangeServiceImpl implements ArrangeService{
    @Value("${server.port}")
    private String ServerPort;

    @Autowired
    private ArrangeMapper arrangeMapper;

    @Autowired
    private CourseService courseService;

    @Override
    public CommonResult get() {
        List<CourseArrange> all = arrangeMapper.getAll();
        if (all.isEmpty()){
            return CommonResult.success(ServerPort+":还未安排课程！",null);
        }
        return CommonResult.success(ServerPort+":查询成功！",all);
    }

    @Override
    public CommonResult findById(int id) {
        CourseArrange courseArrange = arrangeMapper.findById(id);
        if (courseArrange != null){
            return CommonResult.success(ServerPort+":查询成功！",courseArrange);
        }
        return CommonResult.fail(404,ServerPort+":没有该课程！");
    }

    @Override
    public CommonResult addArrange(CourseArrange courseArrange) {
        int course_id = courseArrange.getCourse_id();
        //1、判断该course是否存在？
        CommonResult courseResult = courseService.findById(course_id);
        //int code = courseResult.getCode();
        if (courseResult.getCode()!=200){
            return CommonResult.fail(404,ServerPort+":id="+course_id+"的课程不存在！");
        }
        //2、是否被安排过？
        CourseArrange byCourseId = arrangeMapper.findByCourseId(course_id);
        if (byCourseId != null){
            return CommonResult.fail(444,ServerPort+":id="+course_id+"的课程已经被安排！");
        }
        int res = arrangeMapper.add(courseArrange);
        if (res < 1){
            return CommonResult.fail(444,ServerPort+"安排失败！");
        }
        return CommonResult.success(ServerPort+":安排成功！",courseArrange);
    }

    @Override
    public void select(int id) {
        CourseArrange byCourseId = arrangeMapper.findByCourseId(id);
        if (byCourseId.getSelected_num() < byCourseId.getMax_num()){
            arrangeMapper.select(byCourseId.getSelected_num()+1,id);
        }
    }

    @Override
    public Boolean selected(int id) {
        CourseArrange byCourseId = arrangeMapper.findByCourseId(id);
        return byCourseId.getSelected_num() == byCourseId.getMax_num();
    }


}
