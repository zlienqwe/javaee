package com.tw.controller;

import com.tw.entity.User;
import com.tw.service.UserService;
import com.tw.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

/**
 * Created by twer on 7/9/15.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    private ModelAndView createModelAndView(String viewName, String objectName, Object objectValue){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(viewName);
        modelAndView.addObject(objectName, objectValue);

        return modelAndView;
    }
    private Cookie createLastPageCookie(String cookieValue){
        Cookie cookie = new Cookie("last_page", cookieValue);
        cookie.setPath("/");

        return cookie;
    }

    private Cookie deleteLastPageCookie(){
        Cookie cookie = new Cookie("last_page", null);
        cookie.setMaxAge(0);

        return cookie;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(
                                    @CookieValue(value = "login_user", defaultValue = "") String currentUser,
                                    HttpServletResponse response) {
        if (!currentUser.equals("")) {

            return createModelAndView("users", "users", userService.getAllUsers());
        } else {

            response.addCookie(deleteLastPageCookie());
            response.addCookie(createLastPageCookie("users"));

            return new ModelAndView("redirect:/host/login");
        }
    }



    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name,
                                @RequestParam String sex,
                                @RequestParam String mail,
                                @RequestParam int age) {
        User user = new User(0, name, sex, mail, age, "123456");
        userService.addUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id){

        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUser(@PathVariable int id){
        User user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@RequestParam int id,
                                   @RequestParam String name,
                                   @RequestParam String sex,
                                   @RequestParam String mail,
                                   @RequestParam int age
                                   )throws NoSuchAlgorithmException {
        User user = new User(id, name, sex, mail, age, "123456");
        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }


}