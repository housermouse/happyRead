package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@TableName("t_study")
@Data
public class Study {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("study_id")
    private String studyId;

    @TableField("chapter_id")
    private String chapterId;

    @TableField("video_src")
    private String videoSrc;

    @TableField("document_src")
    private String documentSrc;
}
