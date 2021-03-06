package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;


@Data
@TableName("t_feedback")
public class Feedback {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("feedback_content")
    private String feedbackContent;

    @TableField("create_time")
    private Long createTime;

    @TableField("user_name")
    private String userName;

    @TableField("status")
    private Integer status;


}
