package com.example.jxl.demo.dao;

import com.example.jxl.demo.model.UserInfo;
import com.example.jxl.demo.util.ConnDB;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDao {

    /**
     * 登录
     * @param userInfo
     * @return true:成功 false:失败
     */
    public boolean login(UserInfo userInfo){
        boolean status = false;
        String sql = "select count(*) num from user_info " +
                "where username=? and password=?";
        Connection conn = ConnDB.getConn();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,userInfo.getUsername());
            pst.setString(2,userInfo.getPassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int num = rs.getInt("num");
                if(num>0) status = true; //能查出此人
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<UserInfo> getAll(UserInfo qUserInfo){
        List<UserInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "select id,username,password,sex,add_date from user_info " +
                "where 1=1 ";
        if(qUserInfo != null){
            String username = qUserInfo.getUsername();
            String sex = qUserInfo.getSex();
            if(username!=null && !username.equals("")){//如果查询条件有用户名
                //把查询用户名的条件拼接到sql中
                sql += "and username like'" + username + "%' ";
            }
            if(sex!=null && !sex.equals("")){//如果查询条件有性别
                sql += "and sex='" + sex + "' ";
            }
            System.out.println(sql);
        }
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getInt("id"));
                userInfo.setUsername(rs.getString("username"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setSex(rs.getString("sex"));
                userInfo.setAddDate(rs.getString("add_date"));
                list.add(userInfo);
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
     * 新增
     * @param userInfo
     */
    public void add(UserInfo userInfo){
        Connection conn = ConnDB.getConn();
        String sql = "insert into user_info(username,password,sex,add_date) " +
                "values(?,?,?,now())";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,userInfo.getUsername());
            pst.setString(2,userInfo.getPassword());
            pst.setString(3,userInfo.getSex());
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据主键删除记录
     * @param id
     */
    public void del(Integer id){
        String sql = "delete from user_info where id="+id;
        Connection conn = ConnDB.getConn();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
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
    public UserInfo selById(Integer id){
        UserInfo userInfo = new UserInfo();
        Connection conn = ConnDB.getConn();
        String sql = "select id,username,password,sex,add_date from user_info " +
                "where id="+id;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                userInfo.setId(rs.getInt("id"));
                userInfo.setUsername(rs.getString("username"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setSex(rs.getString("sex"));
                userInfo.setAddDate(rs.getString("add_date"));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    /**
     * 修改
     * @param userInfo
     */
    public void update(UserInfo userInfo){
        Connection conn = ConnDB.getConn();
        String sql = "update user_info set username=?,password=?,sex=? where id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,userInfo.getUsername());
            pst.setString(2,userInfo.getPassword());
            pst.setString(3,userInfo.getSex());
            pst.setInt(4,userInfo.getId());

            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
