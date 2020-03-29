package com.wx.happyread.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@TableName("t_summary")
@Data
public class Summary {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("summary_id")
    private String summaryId;

    @TableField("summary_name")
    private String summaryName;

    private Integer status;


}
