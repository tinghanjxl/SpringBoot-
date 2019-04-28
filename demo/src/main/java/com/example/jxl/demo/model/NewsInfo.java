package com.example.jxl.demo.model;

import java.util.Date;

public class NewsInfo {

    public NewsInfo() {
    }

    public NewsInfo(Integer id, String title, String add_date)
    {
        this.id = id;
        this.title = title;
        //this.contents = contents;
        this.add_date = add_date;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    private String title;
    private String contents;
    private String add_date;

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", add_ate='" + add_date + '\'' +
                '}';
    }



}
