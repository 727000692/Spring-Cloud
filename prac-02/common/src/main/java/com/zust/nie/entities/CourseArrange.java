package com.zust.nie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author njy
 * @Date 2022/4/20 22:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseArrange {
    private int id;
    private int course_id;
    private int teacher_id;
    private String teacher_name;
    private String course_time;
    private String course_place;
    private int max_num;
    private int selected_num;

}
