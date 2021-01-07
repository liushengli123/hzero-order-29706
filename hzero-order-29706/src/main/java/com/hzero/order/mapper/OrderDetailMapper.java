package com.hzero.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.dto.OrderDetailDto;
import com.hzero.order.dto.OrderDetailUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetailUpdateDto> {

    List<OrderDetailDto> selectOrderDetailByOrderNumber(@Param("orderNumber") String orderNumber);

}
