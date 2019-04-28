package com.example.jxl.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/infoController")
public class InfoController {

    @RequestMapping("info")
    public String info(){
        return "info";
    }
}
