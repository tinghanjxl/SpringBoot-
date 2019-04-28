package com.example.jxl.demo.controller;
import com.example.jxl.demo.dao.UserInfoDao;
import com.example.jxl.demo.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController{

    private UserInfoDao userInfoDao = new UserInfoDao();


    @RequestMapping("login")
    public String login(UserInfo userInfo,Model model){
        System.out.println(userInfo);
        if(userInfoDao.login(userInfo)){//成功
            return "main";
        }
        //把页面需要访问的数据放入modle对象
        model.addAttribute("flag","0");
        return "index";

    }

    @RequestMapping("register")
    public String register(){
        System.out.println("register");
        return "";
    }


}
