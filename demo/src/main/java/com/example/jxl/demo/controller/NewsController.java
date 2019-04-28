package com.example.jxl.demo.controller;


import com.example.jxl.demo.dao.NewsDao;
import com.example.jxl.demo.model.NewsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NewsController")
public class NewsController {

    private NewsDao newsDao = new NewsDao();

    @RequestMapping("news")
    public String list (NewsInfo newsInfo, Model model)
    {
        model.addAttribute("list",newsDao.getAll(newsInfo));
        return "news_list";

    }
    @RequestMapping("list_1")
    public String list_1(Integer id,NewsInfo newsInfo, Model model)
    {
        model.addAttribute("click_list",newsDao.click(id));
        return "news_list_1";

    }
    @RequestMapping("list_1_1")
    public String list_1_1(NewsInfo qNewsInfo,Model model)
    {
        model.addAttribute("click_list_1",newsDao.click1(qNewsInfo));

        return "news_list_1";

    }





}
