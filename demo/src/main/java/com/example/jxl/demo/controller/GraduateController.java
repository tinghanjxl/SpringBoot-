package com.example.jxl.demo.controller;


import com.example.jxl.demo.dao.GraduateDao;
import com.example.jxl.demo.model.GraduateInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/graduateController")
public class GraduateController {

    private GraduateDao graduateDao = new GraduateDao();

    @RequestMapping("graduate")
    public String list(GraduateInfo qGraduateInfo,Model model){
        //把查询的记录列表放入model
        model.addAttribute("list",graduateDao.getAll(qGraduateInfo));
        return "graduate_list";
    }

    @RequestMapping("list_1")
    public String list_1(Integer id,GraduateInfo graduateInfo,Model model)
    {
       model.addAttribute("graduate_click",graduateDao.click(id));

       return "graduate_list_1";
    }
    @RequestMapping("graduate_inside")
    public String list_inside(GraduateInfo qGraduateInfo,Model model)
    {
        model.addAttribute("graduate_inside",graduateDao.getAll(qGraduateInfo));
        return "graduate_inside";
    }

    /**
     *跳转到新增页面
     */
    @RequestMapping("graduate_inside_toAdd")
    public String toAdd()
    {
        return "graduate_inside_add";
    }


    /**
     * 新增
     * @param graduateInfo
     * @return
     */
    @RequestMapping("graduate_inside_add")
    public String add(GraduateInfo graduateInfo)
    {
        graduateDao.add(graduateInfo);

        return "redirect:/graduateController/graduate_inside";

    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("graduate_inside_del")
    public String del(Integer id) throws SQLException {
        graduateDao.del(id);
        return "redirect:/graduateController/graduate_inside";

    }

    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping("graduate_inside_toUpdate")
    public String toUpdate(Integer id,Model model)
    {
        model.addAttribute("graduate_update",graduateDao.selById(id));
        return "graduate_inside_update";


    }

    /**
     * 修改
     * @param graduateInfo
     * @return
     */
    @RequestMapping("graduate_inside_update")
    public String update(GraduateInfo graduateInfo)
    {

        graduateDao.update(graduateInfo);
        return "redirect:/graduateController/graduate_inside";

    }

}
