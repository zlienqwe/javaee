package com.tw.dao;


import com.tw.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

/**
 * Created by twer on 15/7/8.
 */
public class UserDao {

    public List<User> selectUser() {

        GetConnection getConnection = new GetConnection();
        Connection con = getConnection.getConnection();

        String selectSql = "SELECT * FROM users";
        ResultSet selectRes = null;
        List<User> userList = new ArrayList<User>();

        try {
            Statement stmt = con.createStatement();
            selectRes = stmt.executeQuery(selectSql);


            while (selectRes.next()) {
                int id = Integer.parseInt(selectRes.getString("id"));
                String name = selectRes.getString("name");
                int age = Integer.parseInt(selectRes.getString("age"));
                String sex = selectRes.getString("sex");
                String mail = selectRes.getString("mail");

                User user = new User(id, name, sex, mail, age);
                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return userList;
    }

    public int addUser(String name, String sex, String mail, int age) {

        GetConnection getConnection = new GetConnection();
        Connection con = getConnection.getConnection();

        String addSql = "INSERT INTO users Values ('" + name + "','" + sex + "','" + mail + "'," + age + ",null)";

        try {
            Statement stmt = con.createStatement();

            int result = stmt.executeUpdate(addSql);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int deleteUser(int id) {

        GetConnection getConnection = new GetConnection();
        Connection con = getConnection.getConnection();

        String deleteSql = "DELETE FROM users WHERE id=" + id;
        try {
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(deleteSql);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public User getUser(int id){

        GetConnection getConnection = new GetConnection();
        Connection con = getConnection.getConnection();
        ResultSet selectRes = null;

        String getUserSql = "SELECT * FROM users WHERE id=" + id;
        try{
            Statement stmt = con.createStatement();
            selectRes= stmt.executeQuery(getUserSql);


            while (selectRes.next()) {
                id = Integer.parseInt(selectRes.getString("id"));
                String name = selectRes.getString("name");
                int age = Integer.parseInt(selectRes.getString("age"));
                String sex = selectRes.getString("sex");
                String mail = selectRes.getString("mail");

                User user = new User(id, name, sex, mail, age);
                return user;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int updateUser(User user) {
        GetConnection getConnection = new GetConnection();
        Connection con = getConnection.getConnection();
        System.out.println("--------");
        String updateSql = "update users set name='"+user.getUserName()+"',sex='"+user.getUserSex()+"',mail='"+user.getUserMail()+"',age="+user.getUserAge()+" where id="+user.getUserId();
            System.out.println(updateSql);
        try {
            Statement stmt = con.createStatement();
            int result  = stmt.executeUpdate(updateSql);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
