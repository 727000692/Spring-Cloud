package com.zust.nie.controller;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.Course;
import com.zust.nie.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author njy
 * @Date 2022/4/20 22:30
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //获取全部课程列表
    @GetMapping("/get")
    public CommonResult getAll(){
        return courseService.getAll();
    }

    //获取某个course
    @GetMapping("/find")
    public CommonResult findById(@RequestParam("id") int id){
        return courseService.findById(id);
    }

    //添加课程
    @PostMapping("/add")
    public CommonResult add(Course course){
        return courseService.add(course);
    }

    //删除课程
    @GetMapping("/delete")
    public CommonResult deleteById(@RequestParam("id") int id){
        return courseService.deleteById(id);
    }




}
