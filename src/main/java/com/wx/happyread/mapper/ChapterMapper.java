package com.wx.happyread.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wx.happyread.model.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {
    List<Chapter> selectChapterList(@Param("summaryId") String summaryId);

}
