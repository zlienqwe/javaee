package com.tw.web;

import com.tw.dao.UserDao;
import com.tw.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by twer on 15/7/9.
 */
@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        int age = new Integer(req.getParameter("age"));
        String mail = req.getParameter("mail");



        UserDao userDao = new UserDao();
        User user = new User(0, name, sex, mail, age);
        userDao.addUser(user);
        res.sendRedirect("/web/show");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
