package com.example.prac01.controller;

import com.example.prac01.dao.TestMapper;
import com.example.prac01.entity.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/28 18:36
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/test")
    public List<TestVo> test(){
        List<TestVo> list = testMapper.select();
        return list;
    }

}
