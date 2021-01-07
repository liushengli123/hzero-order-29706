package com.hzero.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.entity.Line;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface LineMapper extends BaseMapper<Line> {

    Long getMaxLineNumber(@Param("soHeaderId") Long soHeaderId);

    List<Long> getLineNumber(@Param("headerId") Long headerId);

    void deleteBySoLineId(@Param("soLineId") long soLineId);
}
