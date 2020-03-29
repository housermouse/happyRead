package com.wx.happyread.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/happyRead/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @PostMapping("/getContent")
    public JSONObject getContent(@RequestBody JSONObject jsonData){
        return chapterService.getContent(jsonData);
    }

}
