package com.hzero.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.entity.Header;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;


@Mapper
public interface HeaderMapper extends BaseMapper<Header> {

    void deleteBySoHeaderId(@Param("soHeaderId") Long soHeaderId);

    Long selectHeadIdByOrderNumber(@Param("orderNumber") String orderNumber);


    List<Header> selectHeaderByOrderStatus(@Param("orderStatus") String orderStatus);
}
