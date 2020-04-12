package com.wx.happyread.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/happyRead/study")
public class StudyController {

    @Autowired
    private StudyService studyService;

    @PostMapping("/getInfo")
    public JSONObject getStudyInfo(@RequestBody JSONObject jsonData){
        return studyService.getStudyInfo(jsonData);
    }
}
