package com.zust.nie.controller;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.CourseArrange;
import com.zust.nie.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author njy
 * @Date 2022/4/20 23:04
 */
@RestController
@RequestMapping("/arrange")
public class ArrangeController {

    @Autowired
    private ArrangeService arrangeService;

    @GetMapping("/get")
    public CommonResult getAll(){
        return arrangeService.get();
    }

    @GetMapping("/find")
    public CommonResult findById(@RequestParam("id") int id){
        return arrangeService.findById(id);
    }

    @PostMapping("/add")
    public CommonResult addArrange(CourseArrange courseArrange){
        return arrangeService.addArrange(courseArrange);
    }

    @GetMapping("/select")
    public void select(@RequestParam("id") int id){
        arrangeService.select(id);
    }

    @GetMapping("/selected")
    public Boolean selected(@RequestParam("id") int id){
        return arrangeService.selected(id);
    }




}
