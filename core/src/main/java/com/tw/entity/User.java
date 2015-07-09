package com.tw.entity;

/**
 * Created by twer on 15/7/8.
 */
public class User{
    private int UserId;
    private String UserName;
    private String UserSex;
    private String UserMail;
    private int UserAge;

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
