package com.example.prac01.service;

import com.example.prac01.entity.Equipment;
import org.springframework.ui.Model;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author njy
 * @Date 2022/3/21 2:40 下午
 */
public interface EquipmentService {

    /**
     * 添加设备
     * @param equipment
     */
    void addEquipment(Equipment equipment);

    /**
     * 查询所有设备
     * @return
     */
    List<Equipment> queryAll();

    /**
     * 获取当前用户的设备
     * @param session
     * @param model
     */
    void getMyEquip(HttpSession session, Model model);

    /**
     * 删除设备
     * @param id
     */
    void deleteById(int id);

    /**
     * 获取管理员界面的所有信息
     * @param model
     */
    void getAllInfo(Model model);
}
