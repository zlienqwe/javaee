package com.tw.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by twer on 15/7/8.
 */

public class GetConnection {
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users", "root", "");

        } catch (Exception e) {
            System.out.print("MYSQL ERROR:" + e.getMessage());
        }
        return con;
    }


}
