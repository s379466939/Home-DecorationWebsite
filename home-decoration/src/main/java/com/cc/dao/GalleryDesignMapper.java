package com.cc.dao;

import com.cc.model.GalleryDesign;
import com.cc.model.GalleryDesignExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GalleryDesignMapper {
    int countByExample(GalleryDesignExample example);

    int deleteByExample(GalleryDesignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GalleryDesign record);

    int insertSelective(GalleryDesign record);

    List<GalleryDesign> selectByExample(GalleryDesignExample example);

    GalleryDesign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GalleryDesign record, @Param("example") GalleryDesignExample example);

    int updateByExample(@Param("record") GalleryDesign record, @Param("example") GalleryDesignExample example);

    int updateByPrimaryKeySelective(GalleryDesign record);

    int updateByPrimaryKey(GalleryDesign record);
}