package com.wx.happyread.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.model.ErrorBank;
import com.wx.happyread.service.ChapterService;
import com.wx.happyread.service.ErrorBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/happyRead/ErrorBank")
public class ErrorBankController {
    @Autowired
    private ErrorBankService errorBankService;

    @PostMapping("/search")
    public JSONObject searchErrorBank(@RequestBody JSONObject jsonData){
        return   errorBankService.selectErrorBank(jsonData);
    }

    @PostMapping("/add")
    public JSONObject insertErrorBank(@RequestBody JSONObject jsonObject){
        return errorBankService.insertErrBrankList(jsonObject);
    }

    @PostMapping("delete")
    public JSONObject deleteErrorBank(@RequestBody JSONObject jsonObject){
        return errorBankService.deleteErrBrankList(jsonObject);
    }
}
