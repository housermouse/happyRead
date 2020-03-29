package com.wx.happyread.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wx.happyread.model.Chapter;
import com.wx.happyread.model.ErrorBank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ErrorBankMapper  extends BaseMapper<ErrorBank> {


}
