package com.example.jxl.demo.dao;
import com.example.jxl.demo.model.CompanyInfo;
import com.example.jxl.demo.util.ConnDB;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompanyDao {
  public List<CompanyInfo> list(){
        List<CompanyInfo> list = new ArrayList<>();
         Connection conn = ConnDB.getConn();
        String sql = "select id, name,industry from company_info order by add_date desc limit 5";

       PreparedStatement pst = null;

      try {
          pst = conn.prepareStatement(sql);
          ResultSet rs =  pst.executeQuery();
          while (rs.next())
          {
              CompanyInfo companyInfo = new CompanyInfo();
              companyInfo.setId(rs.getInt("id"));
              companyInfo.setName(rs.getString("name"));
              companyInfo.setIndustry(rs.getString("industry"));

              list.add(companyInfo);
          }



          rs.close();
          pst.close();
          conn.close();

      } catch (SQLException e) {
          e.printStackTrace();
      }
      System.out.println(list);
      return list;

      // return new ArrayList<CompanyInfo>();
    }




   public List<CompanyInfo> getAll(CompanyInfo qCompanyInfo)
   {
       CompanyInfo companyInfo = null;
       List<CompanyInfo> list = new ArrayList<>();
       Connection conn = ConnDB.getConn();
       String sql = "select id,name,funds,tel,address,scale,industry,description,add_date from company_info "+
               "where 1=1 ";
       if(qCompanyInfo != null){
           String name = qCompanyInfo.getName();
           String industry = qCompanyInfo.getIndustry();
           if(name!=null && !name.equals("")){//如果查询条件有用户名
               //把查询用户名的条件拼接到sql中
               sql += " and name like'" + name + "' ";
           }
           if(industry!=null && !industry.equals("")){//如果查询条件有性别
               sql += "and industry like'" + industry + "' ";
           }
           System.out.println(sql);
       }

       PreparedStatement pst = null;

       try {
           pst = conn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           while (rs.next())
           {
               companyInfo = new CompanyInfo(rs.getInt("id"),rs.getString("name"),rs.getString("funds"),
                       rs.getString("tel"),rs.getString("address"),rs.getString("scale"),
                       rs.getString("industry"),rs.getString("description"),rs.getString("add_date")
               );
               list.add(companyInfo);

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

   public List<CompanyInfo> click(Integer id)
   {
       List<CompanyInfo> list = new ArrayList<>();

       Connection conn = ConnDB.getConn();
        //名称、注册资金、电话、地址、规模、行业、简介
       String sql = "select name,funds,tel,address,scale,industry,description from company_info where id="+id;

       PreparedStatement pst = null;

       try {
           pst = conn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           while (rs.next())
           {
               CompanyInfo companyInfo = new CompanyInfo();
               companyInfo.setName(rs.getString("name"));
               companyInfo.setFunds(rs.getString("funds"));
               companyInfo.setTel(rs.getString("tel"));
               companyInfo.setAddress(rs.getString("address"));
               companyInfo.setScale(rs.getString("scale"));
               companyInfo.setIndustry(rs.getString("industry"));
               companyInfo.setDescription(rs.getString("description"));
               list.add(companyInfo);
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
     * @param companyInfo
     */
   public void add(CompanyInfo companyInfo)
   {
       Connection conn = ConnDB.getConn();

       String sql = "insert into company_info(name,funds,tel,address,scale,industry,description,add_date)"+
               "values(?,?,?,?,?,?,?,?)";

       try {
           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1,companyInfo.getName());
           pst.setString(2,companyInfo.getFunds());
           pst.setString(3,companyInfo.getTel());
           pst.setString(4,companyInfo.getAddress());
           pst.setString(5,companyInfo.getScale());
           pst.setString(6,companyInfo.getIndustry());
           pst.setString(7,companyInfo.getDescription());
           pst.setString(8,companyInfo.getAdd_date());

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
    public void del(Integer id)
    {
        String sql = "delete from company_info where id="+id;

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


    public CompanyInfo selById(Integer id)
    {
        CompanyInfo companyInfo = new CompanyInfo();

        Connection conn = ConnDB.getConn();

        String sql = "select id,name,funds,tel,address,scale,industry,description add_date from company_info where id="+id;

        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);

            ResultSet rs= pst.executeQuery();

            if(rs.next())
            {
                companyInfo.setId(rs.getInt("id"));
                companyInfo.setName(rs.getString("name"));
                companyInfo.setFunds(rs.getString("funds"));
                companyInfo.setTel(rs.getString("tel"));
                companyInfo.setAddress(rs.getString("address"));
                companyInfo.setScale(rs.getString("scale"));
                companyInfo.setIndustry(rs.getString("industry"));
                companyInfo.setDescription(rs.getString("description"));
                companyInfo.setAdd_date(rs.getString("add_date"));

            }
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyInfo;

    }

    public void update(CompanyInfo companyInfo)
    {
        Connection conn = ConnDB.getConn();
        String sql = "update company_info set name=?,funds=?,tel=?,address=?,scale=?,industry=?,description=?,add_date=? where id=?";
        //String sql = "update post_info set company_name=?,name=?,number=?,sex=?,salary=? where id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1,companyInfo.getName());
            pst.setString(2,companyInfo.getFunds());
            pst.setString(3,companyInfo.getTel());
            pst.setString(4,companyInfo.getAddress());
            pst.setString(5,companyInfo.getScale());
            pst.setString(6,companyInfo.getIndustry());
            pst.setString(7,companyInfo.getDescription());
            pst.setString(8,companyInfo.getAdd_date());

            pst.setInt(9,companyInfo.getId());


            pst.executeUpdate();
            pst.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
