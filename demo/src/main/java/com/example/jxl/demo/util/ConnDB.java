package com.example.jxl.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {


    private static String username = "root";

    private static String password = "louise";

    private static String url =
            "jdbc:mysql://127.0.0.1:3306/employ?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";

    private static Connection conn;

    public static Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    public static void main(String[] args){
        //ConnDB.getConn();

        int sex = 0;
        String s = sex==0?"男":"女";
        if(sex == 0)
        {
            s = "男";
        }
        else
        {
            s = "女";
        }
        System.out.println(s);


    }


}
