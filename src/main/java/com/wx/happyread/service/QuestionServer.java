package com.wx.happyread.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.wx.happyread.mapper.ErrorBankMapper;
import com.wx.happyread.mapper.OptionMapper;
import com.wx.happyread.mapper.QuestionMapper;
import com.wx.happyread.model.ErrorBank;
import com.wx.happyread.model.Option;
import com.wx.happyread.model.Question;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServer {
    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private OptionMapper optionMapper;

    @Resource
    private ErrorBankMapper errorBankMapper;

    @Autowired
    private ErrorBankService errorBankService;

    public JSONObject getContent(JSONObject jsonData){
        JSONObject result = new JSONObject();
        List<Question> chapterList;
        List<Question> resultList = new ArrayList<>();
        result.put("code",1);
        result.put("note","成功");
        try {
            String chapterId = jsonData.getString("chapterId");
            if(StringUtils.isBlank(chapterId)){
                result.put("code",-1);
                result.put("note","失败，原因为参数错误");
                return  result;
            }
            EntityWrapper wrapper = new EntityWrapper<Question>();
            wrapper.eq("chapter_id",chapterId);
            chapterList = questionMapper.selectList(wrapper);
            for(int i=0;i<chapterList.size();i++){
                Question question = chapterList.get(i);
                EntityWrapper optionWrapper = new EntityWrapper<Option>();
                optionWrapper.eq("question_id",question.getQuestionId());
                List<Option> options = optionMapper.selectList(optionWrapper);
                if(options!=null){
                    question.setOptions(options);
                }
                resultList.add(question);
            }
            result.put("list",resultList);
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }

    public JSONObject checkResult(JSONObject jsonData) {
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");
        try {
            JSONObject userInfo = jsonData.getJSONObject("userInfo");
            String nickName = userInfo.getString("nickName");
            JSONArray questionList = jsonData.getJSONArray("questionList");
            for (int i = 0; i < questionList.size(); i++) {
                JSONObject questionData = questionList.getJSONObject(i);
                String questionId = questionData.getString("questionId");
                String selected = questionData.getString("selected");
                Question question = questionMapper.getByQuestionId(questionId);
                if (question == null) {
                    result.put("code", -1);
                    result.put("note", "失败，原因为：此题不存在");
                    return result;
                }
                Option correctOption = optionMapper.getCurrectOption(questionId);
                if(!correctOption.getOptionId().equals(selected)){
                    ErrorBank errorBank = new ErrorBank();
                    errorBank.setChapterId(question.getChapterId());
                    errorBank.setOptionId(selected);
                    errorBank.setQuestionId(questionId);
                    errorBank.setStatus(1);
                    errorBank.setUserName(nickName);
                    ErrorBank check = errorBankService.getOneQuestion(questionId,nickName);
                    if(check ==null){
                        errorBankMapper.insert(errorBank);
                    }
                }
            }
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }
}
