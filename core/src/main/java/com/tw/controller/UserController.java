package com.tw.controller;

import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by twer on 7/9/15.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllUsers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show");
        modelAndView.addObject("user", userService.getAllUsers());
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name,
                                @RequestParam String sex,
                                @RequestParam String mail,
                                @RequestParam int age
                                  ){
        User user = new User(0, name, sex, mail, age);
        userService.addUser(user);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int id){

        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUpdateUserAge(@RequestParam int id){
        User user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("update");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@RequestParam String name,@RequestParam int id,
                                   @RequestParam String sex,
                                   @RequestParam String mail,
                                   @RequestParam int age){
        User user = new User(id, name, sex, mail, age);
        userService.updateUser(user);

        return new ModelAndView("redirect:/");
    }

}