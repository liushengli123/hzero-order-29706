package com.hzero.order.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.OrderDetailDto;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.mapper.OrderDetailMapper;
import com.hzero.order.service.OderDetailService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OderDetailService {

    @Resource
    OrderDetailMapper orderDetailMapper;

    @Override
    public PageInfo<OrderDetailDto> selectOrderDetailByOrderNumber(String orderNumber, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getSize());
        List<OrderDetailDto> orderDetailDtos = orderDetailMapper.selectOrderDetailByOrderNumber(orderNumber);
        return new PageInfo<>(orderDetailDtos);
    }

}
