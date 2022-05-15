package com.example.prac01.controller;

import com.example.prac01.entity.Equipment;
import com.example.prac01.service.EquipmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;



/**
 * @Author njy
 * @Date 2022/3/21 1:52 下午
 */
@Controller
@RequestMapping("/equip")
public class EquipmentController {


    @Autowired
    private EquipmentService equipmentService;


    /**
     * 管理员登录获取信息
     */
    @GetMapping("/all")
    public String all(Model model){
        equipmentService.getAllInfo(model);
        return "admin";
    }

    /**
     * 添加设备
     */
    @PostMapping("/add")
    public String add(Equipment equipment){
        equipmentService.addEquipment(equipment);
        return "redirect:/equip/all";
    }


    /**
     * 登录用户获取自己的设备请求
     */
    @GetMapping("/by_user")
    public String by_user(HttpSession session, Model model){
        equipmentService.getMyEquip(session,model);
        return "user";
    }

    /**
     * 删除设备信息
     */
    @GetMapping("/del")
    public String del(@Param("id") int id){
        equipmentService.deleteById(id);
        return "redirect:/equip/all";
    }





}
