package com.wx.happyread.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wx.happyread.mapper.ErrorBankMapper;
import com.wx.happyread.mapper.OptionMapper;
import com.wx.happyread.mapper.QuestionMapper;
import com.wx.happyread.model.Chapter;
import com.wx.happyread.model.ErrorBank;
import com.wx.happyread.model.Option;
import com.wx.happyread.model.Question;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ErrorBankService {
    @Resource
    ErrorBankMapper errorBankMapper;
    @Resource
    OptionMapper optionMapper;

    @Resource
    QuestionMapper questionMapper;

    public JSONObject selectErrorBank(JSONObject jsonObject){
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");
        List<Question>questionList = new ArrayList<>();
        try {
            String chapter_id = jsonObject.getString("chapterId");
            String status = jsonObject.getString("status");
            String userName = jsonObject.getString("userName");
            if(StringUtils.isBlank(userName)||StringUtils.isBlank(chapter_id)){
                result.put("code",-1);
                result.put("note","失败，原因为：参数错误");
                return result;
            }else {
                EntityWrapper wrapper = new EntityWrapper<ErrorBank>();
                wrapper.eq("chapter_id",chapter_id);
                wrapper.eq("user_name",userName);
                wrapper.eq("status",StringUtils.isBlank(status)?1:status);
                List<ErrorBank> errorBanks = errorBankMapper.selectList(wrapper);
                for(ErrorBank errorBank:errorBanks){
                    Question question = questionMapper.getByQuestionId(errorBank.getQuestionId());
                    EntityWrapper optionWrapper = new EntityWrapper<Option>();
                    optionWrapper.eq("question_id",question.getQuestionId());
                    List<Option> options = optionMapper.selectList(optionWrapper);
                    if(options!=null){
                        question.setOptions(options);
                    }
                    questionList.add(question);
                }
                result.put("list",questionList);
            }
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }


    public JSONObject insertErrBrankList(JSONObject jsonObject){
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");
        try {
            JSONArray ErrList = jsonObject.getJSONArray("errList");
            for(int i=0;i<ErrList.size();i++){
                ErrorBank errorBank = new ErrorBank();
                JSONObject jsonObject1 = ErrList.getJSONObject(i);
                errorBank.setChapterId(jsonObject1.getString("chapterId"));
                errorBank.setUserName(jsonObject1.getString("userName"));
                errorBank.setOptionId(jsonObject1.getString("optionId"));
                errorBank.setQuestionId(jsonObject1.getString("questionId"));
                errorBank.setStatus(StringUtils.isBlank(jsonObject1.getString("status"))?1:jsonObject1.getInteger("status"));
                errorBankMapper.insert(errorBank);
            }
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }


    public JSONObject deleteErrBrankList(JSONObject jsonObject){
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");
        JSONArray errArray = new JSONArray();
        try {
            JSONArray ErrList = jsonObject.getJSONArray("errList");
            for(int i=0;i<ErrList.size();i++){

                JSONObject jsonObject1 = ErrList.getJSONObject(i);
                String quesid = jsonObject1.getString("questionId");
                String opintionID = jsonObject1.getString("optionId");


                if(!StringUtils.isBlank(quesid) && !StringUtils.isBlank(opintionID)){
                    ErrorBank errorBank = new ErrorBank();
                    errorBank.setId(jsonObject1.getInteger("id"));
                    errorBank.setChapterId(jsonObject1.getString("chapterId"));
                    errorBank.setUserName(jsonObject1.getString("userName"));
                    errorBank.setOptionId(jsonObject1.getString("optionId"));
                    errorBank.setQuestionId(jsonObject1.getString("questionId"));
                    Option option = new Option();
                    option.setOptionId(opintionID);
                    option.setQuestionId(quesid);
                    option = optionMapper.selectOne(option);
                    if(option!=null&&optionMapper.selectOne(option).getCorrectOption()==1){
                        errorBank.setStatus(0);
                        errorBankMapper.updateById(errorBank);
                    }else {
                        errArray.add(jsonObject1);
                    }

                }else {
                    //这个表示无效或者错误的数据 做完还是错的错题
                    errArray.add(jsonObject1);
                }
            }
            result.put("errArray",errArray);
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因为："+e.getMessage());
        }
        return result;
    }

    public ErrorBank getOneQuestion(String questionId,String userName){
        ErrorBank errorBank = new ErrorBank();
        errorBank.setUserName(userName);
        errorBank.setQuestionId(questionId);
        ErrorBank result = errorBankMapper.selectOne(errorBank);
        return result;
    }

}
