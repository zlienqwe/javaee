
package com.tw.web;


import com.tw.dao.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setCharacterEncoding("GBK");
        PrintWriter out = res.getWriter();

        Connection connection = new GetConnection().getConnection();

        String selectSql = "SELECT * FROM users";
        ResultSet selectRes = null;

        Statement stmt;


        try {

            stmt = connection.createStatement();

            selectRes = stmt.executeQuery(selectSql);

            while (selectRes.next()) {
                String id = selectRes.getString("id");
                String name = selectRes.getString("name");
                String age = selectRes.getString("age");
                String sex = selectRes.getString("sex");
                String mail = selectRes.getString("mail");

                System.out.print("\r\n\r\n");
                System.out.print("id:" + id + "\n" + "name:" + name + "\n" + "age:" + age + "\n"+ "sex:" + sex + "\n"+ "mail:" + mail + "\n");
                out.println(id);
                out.println(name);
                out.println(mail);
                out.println(age);
                out.println(sex);
                out.println("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        out.close();
    }
}