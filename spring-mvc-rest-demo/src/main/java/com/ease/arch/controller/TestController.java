package com.ease.arch.controller;

import com.ease.arch.entity.User;
import com.ease.arch.service.UserService;
import com.ease.arch.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam(name = "a") String num1, @RequestParam(name = "b") String num2) {
        return "cccdddd" + num1 + num2;
    }


    @RequestMapping(value = "/hello2/{a}/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String hello2(@PathVariable(name = "a") int num1, @PathVariable(name = "b") int num2) {
        return "cccdddd" + num1 + num2;
    }


    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    @ResponseBody
    public String hello3(MultipartFile user) {
        return user.getName();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloPage() {
        return "index";
    }


    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    @ResponseBody
    public User userInfo() {
//        User user = new User();
//        user.setAge(11);
//        user.setName("abc");
        return userService.createUser();
    }
}
