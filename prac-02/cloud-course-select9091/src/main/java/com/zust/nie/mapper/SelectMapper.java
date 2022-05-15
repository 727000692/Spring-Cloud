package com.zust.nie.mapper;

import com.zust.nie.entities.SelectResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/21 10:39
 */
@Mapper
public interface SelectMapper {

    @Select("SELECT * FROM select_result;")
    List<SelectResult> getAll();

    @Select("SELECT * FROM select_result WHERE student_id = #{student_id}")
    List<SelectResult> findByStudentId(int student_id);

    @Select("SELECT * FROM select_result WHERE course_arrange_id = #{course_arrange_id}")
    List<SelectResult> findByCourseId(int course_arrange_id);

    @Insert("INSERT INTO select_result(course_arrange_id,student_id,select_time) VALUES(#{course_arrange_id},#{student_id},#{select_time});")
    int add(SelectResult selectResult);

    @Select("SELECT COUNT(*) FROM select_result WHERE course_arrange_id = #{course_arrange_id} AND student_id = #{student_id}")
    int selected(@Param("course_arrange_id") int course_arrange_id, @Param("student_id") int student_id);
}
