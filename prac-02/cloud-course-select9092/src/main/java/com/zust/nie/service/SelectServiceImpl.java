package com.zust.nie.service;


import com.zust.nie.entities.CommonResult;
import com.zust.nie.entities.SelectResult;
import com.zust.nie.mapper.SelectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/21 10:37
 */
@Service
public class SelectServiceImpl implements SelectService{

    @Value("${server.port}")
    private String ServerPort;

    @Autowired
    private SelectMapper selectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ArrangeService arrangeService;


    @Override
    public CommonResult getAll() {
        List<SelectResult> all = selectMapper.getAll();
        if (all.isEmpty()){
            return CommonResult.success(ServerPort+":没有选课结果！",null);
        }
        return CommonResult.success(ServerPort+":查询成功！",all);
    }

    @Override
    public CommonResult addSelect(SelectResult selectResult) {
        int student_id = selectResult.getStudent_id();
        int course_arrange_id = selectResult.getCourse_arrange_id();

        //1、判断该选课用户是否存在？
        CommonResult byId = userService.findById(student_id);
        if (byId.getCode() != 200){
            return CommonResult.fail(888,ServerPort+":该用户不存在，无法选课！");
        }
        //2、该课程arrange是否存在？
        CommonResult byId1 = arrangeService.findById(course_arrange_id);
        if (byId1.getCode() != 200){
            return CommonResult.fail(888,ServerPort+":该课程安排不存在，无法选课！");
        }
        //3、有没有选满？
        if (arrangeService.selected(course_arrange_id)){
            return CommonResult.fail(888,ServerPort+":该课程已经被选满，无法选课！");
        }
        //4、有没有选过？
        int temp = selectMapper.selected(course_arrange_id,student_id);
        if (temp > 0){
            return CommonResult.fail(888,ServerPort+":该用户已经选过这门课，无法选课！");
        }

        //添加选课记录，在选课安排里selected_num + 1
        Date day=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        selectResult.setSelect_time(sdf.format(day));
        int res = selectMapper.add(selectResult);
        if (res > 0){
            arrangeService.select(selectResult.getCourse_arrange_id());
            return CommonResult.success(ServerPort+":选课成功！",selectResult);
        }

        return CommonResult.fail(888,ServerPort+":选课失败！");
    }

    @Override
    public CommonResult findByStudentId(int student_id) {
        List<SelectResult> selectResults = selectMapper.findByStudentId(student_id);
        if (selectResults != null){
            return CommonResult.success(ServerPort+":查询成功！",selectResults);
        }
        return CommonResult.fail(404,ServerPort+":该学生还没选课！");
    }

    @Override
    public CommonResult findByCourseId(int course_arrange_id) {
        List<SelectResult> selectResults = selectMapper.findByCourseId(course_arrange_id);
        if (selectResults != null){
            return CommonResult.success(ServerPort+":查询成功！",selectResults);
        }
        return CommonResult.fail(404,ServerPort+":该课程还没有人选！");
    }

    @Override
    public CommonResult delete() {
        return null;
    }
}
