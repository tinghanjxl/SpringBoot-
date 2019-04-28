package com.example.jxl.demo.controller;


import com.example.jxl.demo.dao.CompanyDao;
import com.example.jxl.demo.dao.LinkDao;
import com.example.jxl.demo.dao.NewsDao;
import com.example.jxl.demo.dao.PostDao;
import com.example.jxl.demo.model.CompanyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class IndexController {

    private CompanyDao companyDao = new CompanyDao();
    private NewsDao newsDao = new NewsDao();
    private PostDao postDao =new PostDao();
    private LinkDao linkDao = new LinkDao();


    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){
        //取5条最新的新闻
        model.addAttribute("newsList",newsDao.list());

        //取5个最新的公司
        model.addAttribute("companyList",companyDao.list());
        //取5个最新的岗位

        model.addAttribute("postList",postDao.list());

        //取五个最新的链接
        model.addAttribute("linkList",linkDao.list() );

        return "index";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
