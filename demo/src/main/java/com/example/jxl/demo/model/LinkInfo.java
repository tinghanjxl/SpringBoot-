package com.example.jxl.demo.model;

public class LinkInfo {

    public LinkInfo() {
    }
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name;
    private String add_date;
    private String url;


    @Override
    public String toString() {
        return "LinkInfo{" +
                "id=" + id +
                ", name='" +name + '\'' +
                ", add_date='" + add_date + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
