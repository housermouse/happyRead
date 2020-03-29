package com.wx.happyread.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wx.happyread.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    Question getByQuestionId(@Param("questionId") String questionId);
}
