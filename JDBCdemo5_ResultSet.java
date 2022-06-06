package com.itheima.jdbc;

import com.mysql.cj.protocol.Resultset;
import org.junit.Test;

import java.sql.*;

public class JDBCdemo5_ResultSet {

    //  执行DQL查询语句

    @Test
        public void testDML() throws SQLException {
        //1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql:///test";
        String username = "root";
        String password = "13579";
        Connection con = DriverManager.getConnection(url, username, password);

        //3.定义SQL语句
        String sql = "select * from account";

        //4.获取对象
        Statement stmt = con.createStatement();

        //5.执行语句
        ResultSet rs = stmt.executeQuery(sql);

        //6
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double money = rs.getDouble(3);
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println(rs.getInt(1));

        }
        rs.close();
        stmt.close();
        con.close();
    }
}
