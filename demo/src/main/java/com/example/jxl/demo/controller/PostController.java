package com.example.jxl.demo.controller;


import com.example.jxl.demo.dao.PostDao;
import com.example.jxl.demo.model.PostInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/PostController")
public class PostController {

    private PostDao postDao = new PostDao();

    @RequestMapping("post")
    public String list(PostInfo qPostInfo, Model model)
    {
        model.addAttribute("list",postDao.getAll(qPostInfo));
        return "post_list";
    }
    @RequestMapping("list_1")
    public String list_1(Integer id,PostInfo postInfo,Model model)
    {
        model.addAttribute("post_click",postDao.click(id));
        return "post_list_1";
    }
    @RequestMapping("post_inside")
    public String list_inside(PostInfo qPostInfo,Model model)
    {
        model.addAttribute("post_inside",postDao.getAll(qPostInfo));
        return "post_inside";
    }

    @RequestMapping("post_inside_toAdd")
    public String toAdd()
    {
        return "post_inside_add";
    }

    @RequestMapping("post_inside_add")
    public String add(PostInfo postInfo)
    {
        postDao.add(postInfo);

        return "redirect:/PostController/post_inside";
    }


    /**
     * 删除
     * @param id
     * @return
     * @throws SQLException
     */

    @RequestMapping("post_inside_del")
    public String del(Integer id) throws SQLException{

        postDao.del(id);

        return "redirect:/PostController/post_inside";
    }

    /**
     * 跳转到修改页面
     * @return
     */

    @RequestMapping("post_inside_toUpdate")
    public String toUpdate(Integer id,Model model)
    {
        model.addAttribute("post_update",postDao.selById(id));
        return "post_inside_update";
    }

    /**
     * 修改
     * @param postInfo
     * @return
     */
    @RequestMapping("post_inside_update")
    public String update(PostInfo postInfo)
    {
        postDao.update(postInfo);

        return "redirect:/PostController/post_inside";

    }





}
