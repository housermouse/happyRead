package com.wx.happyread.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/happyRead/summary")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @GetMapping("/getSummary")
    public JSONObject getSummary(){
        return summaryService.getSummay();
    }

}
