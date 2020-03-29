package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@TableName("t_option")
@Data
public class Option {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("question_id")
    private String questionId;

    @TableField("option_id")
    private String optionId;

    @TableField("correct_option")
    private Integer correctOption;

    @TableField("option_describe")
    private String optionDescribe;

    @TableField("option_type")
    private String optionType;
}
