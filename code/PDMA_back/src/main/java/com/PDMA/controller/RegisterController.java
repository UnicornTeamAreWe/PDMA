package com.PDMA.controller;

import com.PDMA.entity.User;
import com.PDMA.utils.msg.Message;
import com.PDMA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/register")
    public Message addUser(@RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("username") String username){
        if(userService.hasUser(username))
            return new Message(0,"用户名已被注册",null);
        else {
            User user = new User(username, password, email, "NORMAL");
            userService.saveUser(user);
            return new Message(1, "注册成功", user);
        }
    }
}
