package com.cwfit.controller;

import com.cwfit.mapper.UserMapper;
import com.cwfit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * @author yeyike
 * @date 2020/5/21 - 9:14
 */
@Controller
public class RecordController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public String list(Model model){
        List<User> userList = userMapper.queryUserList();

        model.addAttribute("emps",userList);
        return "ranking";
    }

}
