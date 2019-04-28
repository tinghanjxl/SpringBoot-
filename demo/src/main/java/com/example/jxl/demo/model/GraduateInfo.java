package com.example.jxl.demo.model;

public class GraduateInfo {

    public GraduateInfo() {
    }

    public GraduateInfo(Integer id, String name, String sex, String university, String address, String tel)
    {
      this.id = id;
        this.sex =sex;
        this.name = name;
        this.university = university;
        this.tel = tel;
        this.address = address;
        //this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String sex;
    private String university;
    private String address;
    private String tel;
    private String description;

    @Override
    public String toString() {
        return "GraduateInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", university='" + university + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", description='" + description + '\'' +
                '}';
    }



}
