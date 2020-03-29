package com.wx.happyread.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wx.happyread.mapper.SummaryMapper;
import com.wx.happyread.model.Summary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SummaryService {
    @Resource
    private SummaryMapper summaryMapper;

    public JSONObject getSummay(){
        JSONObject result = new JSONObject();
        List<Summary> summaryList = new ArrayList<>();
        result.put("code",1);
        result.put("note","成功");
        try {
            EntityWrapper wrapper = new EntityWrapper<Summary>();
            summaryList = summaryMapper.selectList(wrapper);
            result.put("list",summaryList);
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因是"+e.getMessage());
        }
        return result;
    }
}
