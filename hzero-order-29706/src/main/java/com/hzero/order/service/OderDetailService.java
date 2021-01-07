package com.hzero.order.service;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.OrderDetailDto;
import com.hzero.order.dto.OrderDetailUpdateDto;
import com.hzero.order.dto.PageRequest;

public interface OderDetailService {

    PageInfo<OrderDetailDto> selectOrderDetailByOrderNumber(String orderNumber, PageRequest pageRequest);

    void updateOrderDetail(OrderDetailUpdateDto updateDto);

    void insertOrderDetail(OrderDetailUpdateDto updateDto);

    void removeOrderDetail(String orderNumber);

}
