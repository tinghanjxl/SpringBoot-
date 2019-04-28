package com.example.jxl.demo.dao;

import com.example.jxl.demo.model.GraduateInfo;
import com.example.jxl.demo.util.ConnDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraduateDao {
    public List<GraduateInfo> getAll(GraduateInfo qGraduateInfo){
        GraduateInfo graduateInfo = null;
        List<GraduateInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "select id,name,sex,university,address,tel from graduate_info "+
                "where 1=1 ";
        if(qGraduateInfo != null){
            String name = qGraduateInfo.getName();
            String university = qGraduateInfo.getUniversity();
            if(name!=null && !name.equals("")){//如果查询条件有用户名
                //把查询用户名的条件拼接到sql中
                sql += " and name like'" + name + "' ";
            }
            if(university!=null && !university.equals("")){//如果查询条件有性别
                sql += "and university like'" + university + "' ";
            }
            System.out.println(sql);
        }

        PreparedStatement pst =null;
        try {
             pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
               graduateInfo = new GraduateInfo(rs.getInt("id"),rs.getString("name"),
                       rs.getString("sex"),rs.getString("university"),rs.getString("address"),
                       rs.getString("tel"));

                list.add(graduateInfo);
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





    public List<GraduateInfo> click(Integer id)
    {
        List<GraduateInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();

        String sql = "select name,sex,university,address,tel from graduate_info where id="+id;
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while (rs.next())
            {
                GraduateInfo graduateInfo = new GraduateInfo();
                graduateInfo.setName(rs.getString("name"));
                graduateInfo.setSex(rs.getString("sex"));
                graduateInfo.setUniversity(rs.getString("university"));
                graduateInfo.setAddress(rs.getString("tel"));
                graduateInfo.setTel(rs.getString("tel"));

                list.add(graduateInfo);


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

    /**
     * 增加
     * @param graduateInfo
     */

    public void add(GraduateInfo graduateInfo)
    {
        Connection conn = ConnDB.getConn();
        // String sql = "select id,name,sex,university,address,tel from graduate_info "+
        //                "where 1=1 ";
        String sql = "insert into graduate_info(name,sex,university,address,tel)"+
                "values(?,?,?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,graduateInfo.getName());
            pst.setString(2,graduateInfo.getSex());
            pst.setString(3,graduateInfo.getUniversity());
            pst.setString(4,graduateInfo.getAddress());
            pst.setString(5,graduateInfo.getTel());
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除
     * @param id
     * @throws SQLException
     */

    public void del(Integer id ) throws SQLException {
        String sql = "delete from graduate_info where id=" + id;
        Connection conn = ConnDB.getConn();


        try {
           PreparedStatement  pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据主键加载记录
     * @param id
     * @return
     */

    public GraduateInfo selById(Integer id)
    {
        GraduateInfo graduateInfo = new GraduateInfo();
        Connection conn = ConnDB.getConn();
        String sql = "select id ,name,sex,university,address,tel from graduate_info "+
                "where id="+id;
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            if(rs.next())
            {
                graduateInfo.setId(rs.getInt("id"));
                graduateInfo.setName(rs.getString("name"));
                graduateInfo.setSex(rs.getString("sex"));
                graduateInfo.setUniversity(rs.getString("university"));
                graduateInfo.setAddress(rs.getString("address"));
                graduateInfo.setTel(rs.getString("tel"));

            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return graduateInfo;

    }
    /**
     * 修改
     * @param graduateInfo
     */
    public void update(GraduateInfo graduateInfo)
    {
        Connection conn = ConnDB.getConn();
        String sql = "update graduate_info set name=?,sex=?,university=?,address=?,tel=? where id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,graduateInfo.getName());
            pst.setString(2,graduateInfo.getSex());
            pst.setString(3,graduateInfo.getUniversity());
            pst.setString(4,graduateInfo.getAddress());
            pst.setString(5,graduateInfo.getTel());
            pst.setInt(6,graduateInfo.getId());


            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }







}
