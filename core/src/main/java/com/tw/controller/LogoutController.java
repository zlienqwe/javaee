package com.tw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by twer on 7/14/15.
 */
@RestController
@RequestMapping("/")
public class LogoutController {
    @RequestMapping(value = "/host/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response) {

        Cookie userCookie = new Cookie("login_user", null);
        userCookie.setMaxAge(0);
        userCookie.setPath("/");
        response.addCookie(userCookie);




        return new ModelAndView("redirect:/host/login");
    }
}
