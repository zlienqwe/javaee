package com.tw.dao;

import com.tw.util.HibernateUtil;
import com.tw.entity.User;
import com.tw.util.MD5Util;
import org.hibernate.Query;
import org.hibernate.Session;



import java.util.List;

/**
 * Created by twer on 7/7/15.
 */
public class UserDao {
    public List<User> getUsersByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql="from User where name=:name";
        Query query = session.createQuery(hql);
        query.setString("name", name);
        return query.list();
    }


    public User getUserById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql="from User where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);
        return (User) query.list().get(0);
    }

    public List<User> selectUser(){
        List<User> user;
        Session session = HibernateUtil.getSessionFactory().openSession();
        user = session.createQuery("FROM User").list();
        session.close();
        return user;
    }

    public void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        User user = new User(0, "lily", "女", "e", 21, MD5Util.md5("111"));

        new UserDao().addUser(user);
    }
}