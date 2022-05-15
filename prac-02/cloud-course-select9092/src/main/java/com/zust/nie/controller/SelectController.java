package com.zust.nie.controller;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.SelectResult;
import com.zust.nie.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author njy
 * @Date 2022/4/21 10:35
 */
@RestController
@RequestMapping("/select")
public class SelectController {

    @Autowired
    private SelectService selectService;

    @GetMapping("/get")
    public CommonResult getAll(){
        return selectService.getAll();
    }

    @PostMapping("/add")
    public CommonResult addSelect(SelectResult selectResult){
        return selectService.addSelect(selectResult);
    }
    @GetMapping("/find_s")
    public CommonResult findByStudentId(@RequestParam("student_id") int student_id){
        return selectService.findByStudentId(student_id);
    }
    @GetMapping("/find_c")
    public CommonResult findByCourseId(@RequestParam("course_arrange_id") int course_arrange_id){
        return selectService.findByCourseId(course_arrange_id);
    }

    @GetMapping("/delete")
    public CommonResult delete(@RequestParam("id") int id){
        return selectService.delete();
    }


}
