package com.example.jxl.demo.model;

public class PostInfo {
    public PostInfo() {
    }

    public PostInfo(Integer id, String company_name, String name, Integer number, String sex, String salary, String description) {
        this.id = id;
        this.company_name = company_name;
        this.name = name;
        this.number = number;
        this.sex = sex;
       // this.education = education;
        this.salary = salary;
        //this.workplace = workplace;
        this.description = description;
        //this.add_date = add_date;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    private String company_name;
    private String name;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    private Integer number;
    private String sex;
    private String education;
    private String salary;
    private String workplace;
    private String description;
    private String add_date;



    @Override
    public String toString() {
        return "PostInfo{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", name='" + number + '\'' +
                ", sex='" + sex + '\'' +
                ", education='" + education + '\'' +
                ", salary='" + salary + '\'' +
                ", workplace='" + workplace + '\'' +
                ", description='" + description + '\'' +
                ", add_date='" + add_date + '\'' +
                '}';



    }
}
