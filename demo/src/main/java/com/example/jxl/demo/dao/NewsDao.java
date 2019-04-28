package com.example.jxl.demo.dao;

import com.example.jxl.demo.model.NewsInfo;
import com.example.jxl.demo.util.ConnDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDao
{
    public List<NewsInfo> list()
    {
        List<NewsInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "SELECT id, title,add_date from news_info order by add_date desc limit 5";

        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while (rs.next())
            {
                NewsInfo newsInfo = new NewsInfo();
                newsInfo.setId(rs.getInt("id"));
                newsInfo.setTitle(rs.getString("title"));
                newsInfo.setAdd_date(rs.getString("add_date"));
                list.add(newsInfo);
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

    public List<NewsInfo> getAll(NewsInfo newsInfo) {
        List<NewsInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "SELECT id,title,add_date from news_info";

        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                newsInfo = new NewsInfo(
                        rs.getInt("id"),
                       rs.getString("title"),
                       rs.getString("add_date")
                );
                list.add(newsInfo);
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
     * 点击
     */

    public List<NewsInfo> click(Integer id)
    {
        List<NewsInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();
        String sql = "SELECT contents from news_info where id="+id;

        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while (rs.next())
            {
                NewsInfo newsInfo = new NewsInfo();
                newsInfo.setContents(rs.getString("contents"));

                list.add(newsInfo);
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
    public List<NewsInfo> click1(NewsInfo qNewsInfo)
    {
        List<NewsInfo> list = new ArrayList<>();
        Connection conn = ConnDB.getConn();

        String sql = "select contents  from news_info "+
                "where 1=1 ";
        if(qNewsInfo!=null)
        {
            String title = qNewsInfo.getTitle();
            if(title!=null&&title.equals(""))
            {
                sql += " and title ='" + title + "' ";
            }
            System.out.println(sql);
        }
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                NewsInfo newsInfo = new NewsInfo();
                newsInfo.setContents(rs.getString("contents"));
                list.add(newsInfo);
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(sql);
        return list;
    }



}
