package com.zust.nie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author njy
 * @Date 2022/4/20 22:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectResult {
    private int id;
    private int course_arrange_id;
    private int student_id;
    private String select_time;
}
