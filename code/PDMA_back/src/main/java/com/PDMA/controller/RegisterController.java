package com.PDMA.controller;

import com.PDMA.entity.SysUser;
import com.PDMA.utils.msg.Message;
import com.PDMA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public Message addUser(@RequestBody Map<String, Object> map) {
        if (userService.hasUser(map.get("username").toString()))
            return new Message(0, "用户名已被注册", null);
        else {
            SysUser user = new SysUser(map.get("username").toString(), map.get("password").toString(), map.get("email").toString(), "NORMAL");
            userService.saveUser(user);
            return new Message(1, "注册成功", user);
        }
    }
}
