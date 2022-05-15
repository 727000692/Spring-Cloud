package com.example.prac01.dao;

import com.example.prac01.entity.TestVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/28 18:37
 */
@Mapper
public interface TestMapper {
    List<TestVo> select();
}
