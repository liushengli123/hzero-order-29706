package com.hzero.order.service;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.OrderDetailDto;
import com.hzero.order.dto.PageRequest;

public interface OderDetailService {

    PageInfo<OrderDetailDto> selectOrderDetailByOrderNumber(String orderNumber, PageRequest pageRequest);

}
