package com.zust.nie.mapper;

import com.zust.nie.entities.Power;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author njy
 * @Date 2022/4/21 20:09
 */
@Mapper
public interface PowerMapper {

    @Select("SELECT * FROM `power` WHERE `token` = #{token};")
    Power checkToken(String token);
}
