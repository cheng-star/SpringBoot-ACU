package com.cwfit.controller;

import com.cwfit.pojo.User;
import com.cwfit.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yeyike
 * @date 2020/4/12 - 16:54
 */
@Controller
@RestController()
@CrossOrigin
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        return userService.queryUser();
    }

    @RequestMapping("/goHomePage")
    public String goHomePage(){
        return "homepage";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "index";
    }

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){

        //具体业务
        //获得当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法，如果没有异常就说明OK了
            System.out.println(username);
//            model.addAttribute("loginUser",username);
            return "redirect:/goHomePage";
        } catch (UnknownAccountException | IncorrectCredentialsException e) {//用户名不存在
            model.addAttribute("msg","用户名或者密码错误！");
            return "index";
        } //密码错误

    }

    @RequestMapping("/goRegister")
    public String goRegister(){
        return "register";
    }

    @RequestMapping("/user/register")
    public String register(User user, Model model){

        int suc = userService.addUser(user);
        model.addAttribute("msg","注册成功");
        return "redirect:/goLogin";

    }

    @RequestMapping("/goPlay")
    public String goPlay(){
        return "playspace";
    }

    @RequestMapping("/noauth")
    public String  Unauthorized(Model model){

        model.addAttribute("msg","未经授权无法访问此页面");
        return "index";
    }
}
