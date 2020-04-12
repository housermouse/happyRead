package com.wx.happyread.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.mapper.StudyMapper;
import com.wx.happyread.model.Study;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudyService {
    @Resource
    private StudyMapper studyMapper;


    public JSONObject getStudyInfo(JSONObject jsonData) {
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");
        Study studyInfo = new Study();
        try {
            String chapterId = jsonData.getString("chapterId");
            if(StringUtils.isNoneBlank(chapterId)){
                Study study = new Study();
                study.setChapterId(chapterId);
               studyInfo =  studyMapper.selectOne(study);
            }
            result.put("studyInfo",studyInfo);
            return result;

        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }
}
