package com.example.jxl.demo.dao;

import com.example.jxl.demo.model.LinkInfo;
import com.example.jxl.demo.util.ConnDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkDao {

    public List<LinkInfo> list()
    {
        List<LinkInfo> list =new ArrayList<>();

        Connection conn = ConnDB.getConn();

        String sql = "select id,name from link_info order by add_date desc limit 5";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while (rs.next())
            {
                LinkInfo linkInfo =new LinkInfo();
                linkInfo.setName(rs.getString("name"));
                linkInfo.setId(rs.getInt("id"));

                list.add(linkInfo);

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

}
