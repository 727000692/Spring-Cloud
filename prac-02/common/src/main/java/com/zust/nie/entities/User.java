package com.zust.nie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author njy
 * @Date 2022/4/18 14:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

    private int id;
    private String login_name;
    private String password;
    private String real_name;
    private int type;

}
