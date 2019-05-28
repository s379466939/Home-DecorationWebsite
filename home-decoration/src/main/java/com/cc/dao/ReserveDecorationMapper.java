package com.cc.dao;

import com.cc.model.ReserveDecoration;
import com.cc.model.ReserveDecorationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReserveDecorationMapper {
    int countByExample(ReserveDecorationExample example);

    int deleteByExample(ReserveDecorationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReserveDecoration record);

    int insertSelective(ReserveDecoration record);

    List<ReserveDecoration> selectByExample(ReserveDecorationExample example);

    ReserveDecoration selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReserveDecoration record, @Param("example") ReserveDecorationExample example);

    int updateByExample(@Param("record") ReserveDecoration record, @Param("example") ReserveDecorationExample example);

    int updateByPrimaryKeySelective(ReserveDecoration record);

    int updateByPrimaryKey(ReserveDecoration record);
}