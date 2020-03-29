package com.wx.happyread.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.happyread.mapper.UserMapper;
import com.wx.happyread.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public JSONObject getUser(JSONObject jsonData){
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("note","成功");
        try{
            String nickName = jsonData.getString("nickName");
            String city = jsonData.getString("city");
            String gender = jsonData.getString("gender");
            if(StringUtils.isBlank(nickName)||StringUtils.isBlank(city)||StringUtils.isBlank(gender)){
                result.put("code",-1);
                result.put("note","失败，原因是参数不正确");
                return result;
            }
            User user = new User();
            user.setCity(city);
            user.setGender(gender);
            user.setNickName(nickName);
            if(userMapper.selectOne(user)!=null){
                result.put("user",user);
            }else {
                userMapper.insert(user);
                result.put("user",user);
            }
        }catch (Exception e){
            result.put("code",-1);
            result.put("note","失败，原因是"+e.getMessage());
        }
        return result;
    }
}
