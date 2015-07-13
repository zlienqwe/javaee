package com.tw.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by twer on 15/7/8.
 */
@Entity
@Table(name="users")
public class User{
    @Id
    @Column(name = "ID")
    private int UserId;
    @Column(name = "Name")
    private String UserName;
    @Column(name = "Sex")
    private String UserSex;
    @Column(name = "Mail")
    private String UserMail;
    @Column(name = "Age")
    private int UserAge;

    public User(){

    }
    public User(int userId, String userName, String userSex, String userMail, int userAge) {
        UserId = userId;
        UserName = userName;
        UserSex = userSex;
        UserMail = userMail;
        UserAge = userAge;
    }

    public int getUserId() {
        return UserId;
    }


    public String getUserName() {
        return UserName;
    }


    public String getUserSex() {
        return UserSex;
    }


    public String getUserMail() {
        return UserMail;
    }


    public int getUserAge() {
        return UserAge;
    }

}




