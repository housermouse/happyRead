package com.wx.happyread.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.SelectableChannel;

@RestController
@RequestMapping("/happyRead/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/getUser")
    private JSONObject getUser(@RequestBody JSONObject jsonData){
        return userService.getUser(jsonData);
    }
}
