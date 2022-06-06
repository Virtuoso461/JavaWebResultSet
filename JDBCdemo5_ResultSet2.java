package com.itheima.jdbc;

import org.junit.Test;
import pojo.Account;

import java.sql.*;
import java.util.ArrayList;

public class JDBCdemo5_ResultSet2 {

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

        ArrayList<Account> list = new ArrayList<>();

        //6
        while (rs.next()) {
            Account account = new Account();

            int id = rs.getInt(1);
            String name = rs.getString(2);
            double money = rs.getDouble(3);

            account.getId(id);
            account.getName(name);
            account.getMoney(money);

            list.add(account);

        }

        System.out.println(list);

        rs.close();
        stmt.close();
        con.close();
    }
}
