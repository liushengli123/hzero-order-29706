package com.hzero.order.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.OrderDetailDto;
import com.hzero.order.dto.OrderDetailUpdateDto;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Line;
import com.hzero.order.mapper.HeaderMapper;
import com.hzero.order.mapper.LineMapper;
import com.hzero.order.mapper.OrderDetailMapper;
import com.hzero.order.service.OderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderDetailServiceImpl implements OderDetailService {

    private static final String NEW_CONSTANT = "NEW";
    private static final String REJECTED_CONSTANT = "REJECTED";

    @Resource
    OrderDetailMapper orderDetailMapper;
    @Resource
    HeaderMapper headerMapper;
    @Resource
    LineMapper lineMapper;

    @Transactional(readOnly = true)
    @Override
    public PageInfo<OrderDetailDto> selectOrderDetailByOrderNumber(String orderNumber, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getSize());
        List<OrderDetailDto> orderDetailDtos = orderDetailMapper.selectOrderDetailByOrderNumber(orderNumber);
        return new PageInfo<>(orderDetailDtos);
    }

    @Override
    public void updateOrderDetail(OrderDetailUpdateDto updateDto) {
        if (!NEW_CONSTANT.equals(updateDto.getHeader().getOrderStatus()) && !REJECTED_CONSTANT.equals(updateDto.getHeader().getOrderStatus())){
            headerMapper.updateById(updateDto.getHeader());
            List<Line> lines = updateDto.getLines();
            for (Line line : lines) {
                lineMapper.updateById(line);
            }
        }
    }

    @Override
    public void insertOrderDetail(OrderDetailUpdateDto updateDto) {
        if (headerMapper.selectById(updateDto.getHeader().getSoHeaderId()) == null) {
            headerMapper.insert(updateDto.getHeader());
        }
        Long soHerderId =updateDto.getHeader().getSoHeaderId();
        List<Line> lines = updateDto.getLines();
        for (Line line:lines){
            Long maxLineNumber = lineMapper.getMaxLineNumber(soHerderId);
            if (maxLineNumber == null) {
                line.setLineNumber(1L);
            } else {
                line.setLineNumber(maxLineNumber + 1L);
            }
            line.setSoHeaderId(soHerderId);
            lineMapper.insert(line);
        }
    }

    @Override
    public void removeOrderDetail(String orderNumber) {
        List<OrderDetailDto> detailDtos = orderDetailMapper.selectOrderDetailByOrderNumber(orderNumber);
        for (OrderDetailDto detailDto : detailDtos) {
            lineMapper.deleteBySoLineId(detailDto.getSoLineId());
        }
        headerMapper.deleteBySoHeaderId(detailDtos.get(0).getSoHeaderId());
    }

}
