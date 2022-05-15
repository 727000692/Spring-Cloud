package com.zust.nie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author njy
 * @Date 2022/4/18 14:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course{
    private int id;
    private String name;
    private float credit;
    private String type;

}
