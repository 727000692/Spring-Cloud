package com.zust.nie.mapper;

import com.zust.nie.entities.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/4/20 22:32
 */
@Mapper
public interface CourseMapper {

    @Select("SELECT * FROM course;")
    List<Course> getAll();

    @Select("SELECT * FROM course WHERE id = #{id};")
    Course findById(int id);

    @Insert("INSERT INTO course(name,credit,type) VALUES(#{name},#{credit},#{type});")
    int add(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    int deleteById(int id);
}
