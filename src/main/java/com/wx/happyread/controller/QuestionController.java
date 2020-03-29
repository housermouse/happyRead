package com.wx.happyread.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.service.QuestionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/happyRead/question")
public class QuestionController {
    @Autowired
    private QuestionServer questionServer;

    @PostMapping("/getContent")
    public JSONObject getContent(@RequestBody JSONObject jsonData){
        return questionServer.getContent(jsonData);
    }

    @PostMapping("/checkResult")
    public JSONObject checkResult(@RequestBody JSONObject jsonData){
        return questionServer.checkResult(jsonData);
    }
}
