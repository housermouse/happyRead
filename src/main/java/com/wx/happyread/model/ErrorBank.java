package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("t_error_bank")
public class ErrorBank {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("chapter_id")
    private String chapterId;

    @TableField("user_name")
    private String userName;

    @TableField("question_id")
    private String questionId;

    @TableField("option_id")
    private String optionId;

    @TableField("status")
    private Integer status;
}
