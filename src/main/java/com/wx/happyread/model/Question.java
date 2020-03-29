package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.List;

@TableName("t_question")
@Data
public class Question {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("question_id")
    private String questionId;

    @TableField("question_name")
    private String questionName;

    @TableField("question_describe")
    private String questionDescribe;

    @TableField("chapter_id")
    private String chapterId;

    @TableField(exist = false)
    private List<Option> options;
}
