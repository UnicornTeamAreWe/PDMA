package com.PDMA.controller;

import com.PDMA.entity.User;
import com.PDMA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUsers")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping(value="/getUser")
    public User getUser(@RequestParam("userId")Long userId){
        return userService.getUser(userId);
    }

    @RequestMapping(value="/setType")
    public @ResponseBody void setType(@RequestParam("userId") Long userId,
                                      @RequestParam("type") String type){
        userService.setType(userId, type);
    }
}
