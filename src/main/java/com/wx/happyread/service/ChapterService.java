package com.wx.happyread.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.mapper.ChapterMapper;
import com.wx.happyread.model.Chapter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper mapper;

    public JSONObject getContent(JSONObject jsonData){
        JSONObject result = new JSONObject();
        List<Chapter> chapterList;
        result.put("code",1);
        result.put("note","成功");
        try {
            String summaryId = jsonData.getString("summaryId");
            if(StringUtils.isBlank(summaryId)){
                result.put("code",-1);
                result.put("note","失败，原因为参数错误");
                return  result;
            }
            chapterList = mapper.selectChapterList(summaryId);
            result.put("list",chapterList);
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }
}
