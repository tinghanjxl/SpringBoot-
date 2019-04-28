package com.example.jxl.demo.model;

public class CompanyInfo {

    public CompanyInfo() {
    }

    public CompanyInfo(Integer id, String name, String funds, String tel, String address, String scale, String industry,String description, String add_date)
    {
        this.id = id;
        this.name = name;
        this.funds = funds;
        this.tel= tel;
        this.address = address;
        this.scale = scale;
        this.industry = industry;
        this.description =description;
        this.add_date = add_date;

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

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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

    private String name;
    private String funds;
    private String tel;
    private String address;
    private String scale;
    private String industry;
    private String description;
    private String add_date;

    @Override
    public String toString() {

        return "CompanyInfo{" +
                "id=" + id +
                ", name='" +name + '\'' +
                ", funds='" + funds + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", scale='" + scale + '\'' +
                ", industry='" + industry + '\'' +
                ", description='" + description + '\'' +
                ", add_date='" + add_date + '\'' +
                '}';

    }
}
