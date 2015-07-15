package com.tw.controller;

import com.tw.util.MD5Util;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by twer on 7/14/15.
 */
//@Controller
@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    private String getLastUrl(String lastUrl){
        String lastPageUrl = "users/";
        if(!lastUrl.equals("/")){
            lastPageUrl = lastUrl;
        }
        return lastPageUrl;
    }

    @RequestMapping(value = "/host/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logIn");
        return modelAndView;
    }


    @RequestMapping(value = "/host/login", method = RequestMethod.POST)
    public ModelAndView getLogInMessage(@CookieValue(value = "last_page", defaultValue = "/") String lastUrl,
                                        @RequestParam String name,
                                        @RequestParam String password,
                                        HttpServletResponse response) {

        List<User> users = userService.getUsersByName(name);
        if (users.size() != 0) {
            User loginUser = users.get(0);
            String logInMessage = userService.canLogIn(loginUser, MD5Util.md5(password));
            if (logInMessage.equals("密码正确")) {
                Cookie cookie = new Cookie("login_user", loginUser.getUserName());
                cookie.setPath("/");
                response.addCookie(cookie);

                String url = this.getLastUrl(lastUrl);

                return new ModelAndView("redirect:/" + url);
            } else {
                return new ModelAndView("redirect:/userError");
            }

        } else {
            return new ModelAndView("redirect:/userError");
        }


    }

    @RequestMapping("/userError")
    public ModelAndView getUserError() {
        return new ModelAndView("userError");
    }
}
