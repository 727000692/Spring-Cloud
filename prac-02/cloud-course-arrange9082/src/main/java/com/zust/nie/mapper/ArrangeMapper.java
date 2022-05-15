package com.zust.nie.mapper;

import com.zust.nie.entities.CourseArrange;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/20 23:13
 */
@Mapper
public interface ArrangeMapper {

    @Select("SELECT * FROM course_arrange")
    List<CourseArrange> getAll();

    @Select("SELECT * FROM course_arrange WHERE course_id = #{course_id}")
    CourseArrange findByCourseId(int course_id);

    @Select("SELECT * FROM course_arrange WHERE id = #{id}")
    CourseArrange findById(int id);

    @Insert("INSERT INTO course_arrange(course_id,teacher_id,teacher_name,course_time,course_place,max_num,selected_num) VALUES(#{course_id},#{teacher_id},#{teacher_name},#{course_time},#{course_place},#{max_num},0);")
    int add(CourseArrange courseArrange);

    @Update("UPDATE course_arrange SET selected_num = #{selected_num} WHERE id = #{id}")
    void select(@Param("selected_num") int selected_num, @Param("id") int id);
}
