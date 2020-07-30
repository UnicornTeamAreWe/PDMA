package com.PDMA.controller;

import com.PDMA.entity.User;
import com.PDMA.service.UserService;
import com.PDMA.utils.msg.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/login")
    public Message login(@RequestBody Map<String,Object> map){
        User user = userService.checkUser(map.get("username").toString(), map.get("password").toString());
        if(user == null){
            return new Message(0,"error username or password",null);
        }else{
            if(user.getType().equals("ADMIN")){
                return new Message(100,"successfully login!",user);
            }
            else if(user.getType().equals("BANNED")){
                return new Message(-1,"Sorry, you are banned",user);
            }
            return new Message(1,"successfully login!",user);
        }
    }

}
