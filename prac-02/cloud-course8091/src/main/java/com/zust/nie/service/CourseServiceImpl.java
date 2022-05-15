package com.zust.nie.service;

import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.Course;
import com.zust.nie.entities.CourseArrange;
import com.zust.nie.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/20 22:31
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    @Value("${server.port}")
    private String ServerPort;

    @Override
    public CommonResult getAll() {
        List<Course> all = courseMapper.getAll();
        if (all.isEmpty()){
            return CommonResult.success(ServerPort+":课程列表为空！",null);
        }
        return CommonResult.success(ServerPort+":查询成功！",all);
    }

    @Override
    public CommonResult add(Course course) {
        int res = courseMapper.add(course);
        if (res < 1){
            return CommonResult.fail(888,ServerPort+":添加失败！");
        }
        return CommonResult.success(ServerPort+":添加成功！",course);
    }

    @Override
    public CommonResult deleteById(int id) {
        int res = courseMapper.deleteById(id);
        if (res < 1){
            return CommonResult.fail(888,ServerPort+":删除失败！");
        }
        return CommonResult.success(ServerPort+":删除成功！",null);
    }

    @Override
    public CommonResult findById(int id) {
        Course course = courseMapper.findById(id);
        if (course != null){
            return CommonResult.success(ServerPort+":查询成功！",course);
        }
        return CommonResult.fail(404,ServerPort+":没有该课程！");
    }
}
