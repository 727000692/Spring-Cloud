package com.example.prac01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author njy
 * @Date 2022/3/21 1:47 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    private int id;
    private String name;
    private String description;
    private String code;
    private String add_time;
    private BigDecimal price;
    private String place;
    private String user_name;
}
