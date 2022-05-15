package com.example.prac01.dao;

import com.example.prac01.entity.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author njy
 * @Date 2022/3/21 2:44 下午
 */
@Repository
public interface EquipmentMapper {


    void addEquipment(Equipment equipment);


    List<Equipment> queryAll();


    List<Equipment> queryByName(String username);


    void deleteById(int id);
}
