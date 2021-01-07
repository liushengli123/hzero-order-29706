package com.hzero.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.dto.Order;
import com.hzero.order.dto.OrderCondition;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> selectOrdersByCondition(OrderCondition orderCondition);

}
