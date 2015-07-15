package com.tw.service;

import com.tw.dao.UserDao;
import com.tw.entity.User;
import com.tw.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao = new UserDao();


    public List<User> getAllUsers(){

        return userDao.selectUser();
    }
    public void addUser(User user){
        userDao.addUser(user);
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public void deleteUser(User user){
        userDao.deleteUser(user);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }

    public String canLogIn(User user, String password) {

        if (user.getPassword().equals(password)) {
            return "密码正确";
        } else {
            return "密码错误";
        }
    }
}