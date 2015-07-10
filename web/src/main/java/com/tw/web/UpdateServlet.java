package com.tw.web;

import com.tw.entity.User;
import com.tw.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by twer on 15/7/9.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        int age = new Integer(req.getParameter("age"));
        String mail = req.getParameter("mail");
        int id = new Integer(req.getParameter("id"));
        User user = new User(id, name, sex, mail, age);
        UserDao userDao = new UserDao();

        userDao.updateUser(user);
        res.sendRedirect("/web/show");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        UserDao userDao = new UserDao();
        User user = userDao.getUser(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("update.jsp").forward(req, res);
    }
}
