package com.wx.happyread.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wx.happyread.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
