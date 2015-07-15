package com.tw.controller;

import org.springframework.stereotype.Controller;
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
        Cookie usercookie = new Cookie("login_user", null);
        usercookie.setMaxAge(0);
        response.addCookie(usercookie);


        Cookie pageCookie = new Cookie("last_page", null);
        pageCookie.setMaxAge(0);
        pageCookie.setPath("/");
        response.addCookie(pageCookie);

        return new ModelAndView("redirect:/host/login");
    }
}
