package com.wx.happyread.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/happyRead/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/input")
    public JSONObject inputFeedback(@RequestBody JSONObject jsonData){
        return feedbackService.inputFeedback(jsonData);
    }

    @RequestMapping("/getList")
    public JSONObject getList(){
        return feedbackService.getList();
    }
}
