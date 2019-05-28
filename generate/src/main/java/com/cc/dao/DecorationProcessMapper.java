package com.cc.dao;

import com.cc.model.DecorationProcess;
import com.cc.model.DecorationProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DecorationProcessMapper {
    int countByExample(DecorationProcessExample example);

    int deleteByExample(DecorationProcessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DecorationProcess record);

    int insertSelective(DecorationProcess record);

    List<DecorationProcess> selectByExample(DecorationProcessExample example);

    DecorationProcess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DecorationProcess record, @Param("example") DecorationProcessExample example);

    int updateByExample(@Param("record") DecorationProcess record, @Param("example") DecorationProcessExample example);

    int updateByPrimaryKeySelective(DecorationProcess record);

    int updateByPrimaryKey(DecorationProcess record);
}