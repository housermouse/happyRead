package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@TableName("t_user")
@Data
public class User {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("nick_name")
    private String nickName;

    private String city;

    private String gender;
}
