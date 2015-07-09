package com.tw.web;

import com.tw.core.Show;
import com.tw.dao.UserDao;
import com.tw.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ShowServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        UserDao userDao = new UserDao();

        List<User> userList = userDao.selectUser();

        req.setAttribute("userList",userList);
        req.getRequestDispatcher("show.jsp").forward(req,res);

    }
}