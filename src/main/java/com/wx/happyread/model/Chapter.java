package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@TableName("t_chapter")
@Data
public class Chapter {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("chapter_name")
    private String chapterName;

    @TableField("chapter_id")
    private Integer chapterId;

    @TableField("summary_id")
    private String summaryId;


    private String describe;

//    @Override
//    public String toString() {
//        return "Chapter{" +
//                "id='" + id + '\'' +
//                ", chapterName=" + chapterName +
//                ", chapterId="+chapterId+
//                ", describe='" + describe + '\'' +
//                '}';
//    }
}
