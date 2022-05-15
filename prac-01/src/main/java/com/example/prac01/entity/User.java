package com.example.prac01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author njy
 * @Date 2022/3/21 1:48 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private int type;
    private String last_login_time;

}
