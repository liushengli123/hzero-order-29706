package com.hzero.order.controller;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.Msg;
import com.hzero.order.dto.OrderDetailDto;
import com.hzero.order.dto.OrderDetailUpdateDto;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Line;
import com.hzero.order.mapper.HeaderMapper;
import com.hzero.order.mapper.LineMapper;
import com.hzero.order.mapper.OrderDetailMapper;
import com.hzero.order.service.Impl.OrderDetailServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/V7")
public class OderDetailController {

    @Resource
    OrderDetailServiceImpl orderDetailServiceImpl;
    @Resource
    HeaderMapper headerMapper;
    @Resource
    LineMapper lineMapper;
    @Resource
    OrderDetailMapper orderDetailMapper;

//    private static final String NEW_CONSTANT = "NEW";
//    private static final String REJECTED_CONSTANT = "REJECTED";

    @ApiOperation(value = "销售订单明细页面")
    @GetMapping("/query")
    public Msg selectOrderDetailByOrderNumber(@RequestParam String orderNumber, PageRequest pageRequest) {
        PageInfo<OrderDetailDto> pageInfo = orderDetailServiceImpl.selectOrderDetailByOrderNumber(orderNumber, pageRequest);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @ApiOperation(value = "销售订单明细修改")
    @PutMapping
    public Msg update(@RequestBody OrderDetailUpdateDto updateDto) {
//        if (!NEW_CONSTANT.equals(updateDto.getHeader().getOrderStatus()) && !REJECTED_CONSTANT.equals(updateDto.getHeader().getOrderStatus())){
            headerMapper.updateById(updateDto.getHeader());
            List<Line> lines = updateDto.getLines();
            for (Line line : lines) {
                lineMapper.updateById(line);
//           }
        }
        return Msg.success();
    }

    @ApiOperation(value = "新增销售订单")
    @PostMapping
    public Msg insert(@RequestBody OrderDetailUpdateDto updateDto) {
        headerMapper.insert(updateDto.getHeader());
        List<Line> lines = updateDto.getLines();
        for (Line line:lines){
            lineMapper.insert(line);
        }
        return Msg.success();
    }

    @ApiOperation(value = "删除销售订单")
    @DeleteMapping
    public Msg removeOrderDetail(@RequestParam String orderNumber) {
        List<OrderDetailDto> detailDtos = orderDetailMapper.selectOrderDetailByOrderNumber(orderNumber);
        for (OrderDetailDto detailDto : detailDtos) {
            lineMapper.deleteBySoLineId(detailDto.getSoLineId());
        }
        headerMapper.deleteBySoHeaderId(detailDtos.get(0).getSoHeaderId());
        return Msg.success();
    }
}
