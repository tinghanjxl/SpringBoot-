package com.example.jxl.demo.dao;

import com.example.jxl.demo.model.CompanyInfo;
import com.example.jxl.demo.model.PostInfo;
import com.example.jxl.demo.util.ConnDB;
import javafx.geometry.Pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    public List<PostInfo> list()
    {
        List<PostInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "select id,name,salary from post_info order by add_date desc limit 5";

        PreparedStatement pst = null;


        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                PostInfo postInfo =new PostInfo();

                postInfo.setId(rs.getInt("id"));
                postInfo.setName(rs.getString("name"));
                postInfo.setSalary(rs.getString("salary"));

                list.add(postInfo);
            }
            rs.close();
            pst.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;

    }

    public List<PostInfo> getAll(PostInfo qPostInfo)
    {
        PostInfo postInfo = null;
        List<PostInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "select id,company_name, name, number,sex,salary,description from post_info "+
                "where 1=1 ";
        if(qPostInfo != null){
            String company_name = qPostInfo.getCompany_name();
            String name = qPostInfo.getName();
            if(name!=null && !name.equals("")){//如果查询条件有用户名
                //把查询用户名的条件拼接到sql中
                sql += " and name like'" + name + "' ";
            }
            if(company_name!=null && !company_name.equals("")){//如果查询条件有性别
                sql += "and company_name like'" + company_name + "' ";
            }
            System.out.println(sql);
        }

        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                postInfo = new PostInfo(rs.getInt("id"),rs.getString("company_name"),
                        rs.getString("name"),rs.getInt("number"),rs.getString("sex"),
                        rs.getString("salary"),rs.getString("description")
                );
                list.add(postInfo);
            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    public List<PostInfo> click(Integer id)
    {
        List<PostInfo> list = new ArrayList<>();

        Connection conn = ConnDB.getConn();
        //公司、岗位名称、招聘人数、性别要求、月薪、学历、工作地点、职位描述
        String sql = "select company_name,name,number,sex,salary,education,workplace,description from post_info where id="+id;

        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
               PostInfo postInfo = new PostInfo();
               postInfo.setCompany_name(rs.getString("company_name"));
               postInfo.setName(rs.getString("name"));
               postInfo.setNumber(rs.getInt("number"));
               postInfo.setSex(rs.getString("sex"));
               postInfo.setSalary(rs.getString("salary"));
               postInfo.setEducation(rs.getString("education"));
               postInfo.setWorkplace(rs.getString("workplace"));
               postInfo.setDescription(rs.getString("description"));

                list.add(postInfo);

            }
            rs.close();;
            pst.close();;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(list);
        return list;
    }
    /**
     * 增加
     * @param postInfo
     */
    public void add(PostInfo postInfo)
    {
        Connection conn = ConnDB.getConn();
        String sql = "insert into post_info(company_name,name,number,sex,salary)"+
                "values(?,?,?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,postInfo.getCompany_name());
            pst.setString(2,postInfo.getName());
            pst.setInt(3,postInfo.getNumber());
            pst.setString(4,postInfo.getSex());
            pst.setString(5,postInfo.getSalary());

            pst.executeUpdate();
            pst.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     */
    public void del(Integer id) throws SQLException
    {
        String sql = "delete from post_info where id="+id;
        Connection conn = ConnDB.getConn();

        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            conn.close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public PostInfo selById(Integer id)
    {
        PostInfo postInfo = new PostInfo();
        Connection conn = ConnDB.getConn();

        String sql = "select id,company_name,name,number,sex,salary from post_info "+
                "where id="+id;
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                postInfo.setId(rs.getInt("id"));
                postInfo.setCompany_name(rs.getString("company_name"));
                postInfo.setName(rs.getString("name"));
                postInfo.setNumber(rs.getInt("number"));
                postInfo.setSex(rs.getString("sex"));
                postInfo.setSalary(rs.getString("salary"));
            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postInfo;
    }

    /**
     * 修改
     * @param postInfo
     */
    public void update(PostInfo postInfo)
    {
        Connection conn = ConnDB.getConn();
        String sql = "update post_info set company_name=?,name=?,number=?,sex=?,salary=? where id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1,postInfo.getCompany_name());
            pst.setString(2,postInfo.getName());
            pst.setInt(3,postInfo.getNumber());
            pst.setString(4,postInfo.getSex());
            pst.setString(5,postInfo.getSalary());

            pst.setInt(6,postInfo.getId());
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }






}





