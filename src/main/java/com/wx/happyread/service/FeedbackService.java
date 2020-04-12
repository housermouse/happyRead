package com.wx.happyread.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysql.jdbc.TimeUtil;
import com.wx.happyread.mapper.FeedbackMapper;
import com.wx.happyread.model.Feedback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class FeedbackService {

    @Resource
    private FeedbackMapper feedbackMapper;

    public JSONObject inputFeedback(JSONObject jsonData) {
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");

        try {
            String feedbackContent = jsonData.getJSONObject("content").toString();
            String userName = jsonData.getString("userName");
            if(StringUtils.isNoneBlank(feedbackContent)&&StringUtils.isNoneBlank(userName)){
                Feedback feedback = new Feedback();
                feedback.setCreateTime(System.currentTimeMillis());
                feedback.setFeedbackContent(feedbackContent);
                feedback.setUserName(userName);
                feedback.setStatus(1);
                feedbackMapper.insert(feedback);
            }
            return result;

        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }

    public JSONObject getList(){
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            EntityWrapper<Feedback> wrapper = new EntityWrapper<>();

            feedbackList = feedbackMapper.selectList(wrapper);

        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        result.put("list",feedbackList);
        return result;
    }
}
