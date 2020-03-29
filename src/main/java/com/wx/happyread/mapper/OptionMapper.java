package com.wx.happyread.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wx.happyread.model.Option;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OptionMapper extends BaseMapper<Option> {
    Option getCurrectOption(@Param("questionId") String question);
}
