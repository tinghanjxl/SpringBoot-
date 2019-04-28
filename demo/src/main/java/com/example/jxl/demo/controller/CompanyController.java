package com.example.jxl.demo.controller;


import com.example.jxl.demo.dao.CompanyDao;
import com.example.jxl.demo.model.CompanyInfo;
import com.example.jxl.demo.model.PostInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/CompanyController")
public class CompanyController {

    private CompanyDao companyDao = new CompanyDao();

    @RequestMapping("company")
    public String list(CompanyInfo qCcompanyInfo, Model model)
    {
        model.addAttribute("list",companyDao.getAll(qCcompanyInfo));
        return "company_list";

    }
    @RequestMapping("list_1")
    public String list_1(Integer id,CompanyInfo companyInfo,Model model)
    {

        model.addAttribute("company_click",companyDao.click(id));
        return "company_list_1";


    }
    @RequestMapping("company_inside")
    public String list_inside(CompanyInfo qCompanyInfo,Model model)
    {
        model.addAttribute("company_inside",companyDao.getAll(qCompanyInfo));
        return "company_inside";

    }
    @RequestMapping("company_inside_toAdd")
    public String toAdd()
    {
        return "company_inside_add";
    }

    @RequestMapping("company_inside_add")
    public String add(CompanyInfo companyInfo)
    {
        companyDao.add(companyInfo);

        return "redirect:/CompanyController/company_inside";
    }


    /**
     * 删除
     * @param id
     * @return
     * @throws SQLException
     */

    @RequestMapping("company_inside_del")
    public String del(Integer id) throws SQLException{

        companyDao.del(id);

        return "redirect:/CompanyController/company_inside";
    }

    /**
     * 跳转到修改页面
     * @return
     */

    @RequestMapping("company_inside_toUpdate")
    public String toUpdate(Integer id,Model model)
    {
        model.addAttribute("company_update",companyDao.selById(id));
        return "company_inside_update";
    }

    /**
     * 修改
     * @param postInfo
     * @return
     */
    @RequestMapping("company_inside_update")
    public String update(CompanyInfo companyInfo)
    {
        companyDao.update(companyInfo);

        return "redirect:/CompanyController/company_inside";

    }






}
