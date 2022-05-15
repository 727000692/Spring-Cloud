package com.zust.nie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author njy
 * @Date 2022/4/21 22:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Power {
    private int id;
    private String token;
    private int user_id;
    private int user_type;
}
