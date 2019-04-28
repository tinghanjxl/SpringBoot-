package com.example.jxl.demo.controller;


import com.example.jxl.demo.dao.UserInfoDao;
import com.example.jxl.demo.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")


public class UserInfoController {

    private UserInfoDao userInfoDao = new UserInfoDao();

    /**
     * 新增
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(UserInfo userInfo,Model model){
        //把查询的记录列表放入model
        model.addAttribute("list",userInfoDao.getAll(userInfo));
        return "user_list";
    }

    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "user_add";
    }

    /**
     * 新增
     * @param userInfo
     * @return
     */
    @RequestMapping("add")
    public String add(UserInfo userInfo){
        userInfoDao.add(userInfo);
        //重定向到url地址是:/user/list
        return "redirect:/user/list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("del")
    public String del(Integer id){
        userInfoDao.del(id);
        //重定向到url地址是:/user/list
        return "redirect:/user/list";
    }

    /**
     * 跳转到修改页面
     * @param id
     * @return
     */
    @RequestMapping("toUpdate")
    public String toUpdate(Integer id,Model model){
        //根据主键加载记录放入model
        model.addAttribute("userInfo",userInfoDao.selById(id));
        return "user_update";
    }

    /**
     * 悠改
     * @param userInfo
     * @return
     */
    @RequestMapping("update")
    public String update(UserInfo userInfo){
        userInfoDao.update(userInfo);
        return "redirect:/user/list";
    }

}
