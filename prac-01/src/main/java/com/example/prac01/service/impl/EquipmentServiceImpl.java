package com.example.prac01.service.impl;

import com.example.prac01.dao.EquipmentMapper;
import com.example.prac01.dao.UserMapper;
import com.example.prac01.entity.Equipment;
import com.example.prac01.entity.User;
import com.example.prac01.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author njy
 * @Date 2022/3/21 2:42 下午
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addEquipment(Equipment equipment) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format1 = format.format(date);
        equipment.setAdd_time(format1);
        equipmentMapper.addEquipment(equipment);
    }

    @Override
    public List<Equipment> queryAll() {
        return equipmentMapper.queryAll();
    }

    @Override
    public void getMyEquip(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Equipment> equipments = equipmentMapper.queryByName(user.getUsername());
        model.addAttribute("equipments",equipments);
    }

    @Override
    public void deleteById(int id) {
        equipmentMapper.deleteById(id);
    }

    @Override
    public void getAllInfo(Model model) {
        List<Equipment> equipments = equipmentMapper.queryAll();
        List<User> users = userMapper.queryAll();
        model.addAttribute("equipments",equipments);
        model.addAttribute("users",users);
    }
}
