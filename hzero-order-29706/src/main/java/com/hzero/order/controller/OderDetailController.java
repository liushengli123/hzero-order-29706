package com.hzero.order.controller;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.Msg;
import com.hzero.order.dto.OrderDetailDto;
import com.hzero.order.dto.OrderDetailUpdateDto;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.service.Impl.OrderDetailServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/V7")
public class OderDetailController {

    @Resource
    OrderDetailServiceImpl orderDetailServiceImpl;

    @ApiOperation(value = "销售订单明细页面")
    @GetMapping("/query")
    public Msg selectOrderDetailByOrderNumber(@RequestParam String orderNumber, PageRequest pageRequest) {
        PageInfo<OrderDetailDto> pageInfo = orderDetailServiceImpl.selectOrderDetailByOrderNumber(orderNumber, pageRequest);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @ApiOperation(value = "销售订单明细修改")
    @PutMapping
    public Msg updateOrderDetail(@RequestBody OrderDetailUpdateDto updateDto) {
        orderDetailServiceImpl.updateOrderDetail(updateDto);
        return Msg.success();
    }

    @ApiOperation(value = "新增销售订单")
    @PostMapping
    public Msg insertOrderDetail(@RequestBody OrderDetailUpdateDto updateDto) {
        orderDetailServiceImpl.insertOrderDetail(updateDto);
        return Msg.success();
    }

    @ApiOperation(value = "删除销售订单")
    @DeleteMapping
    public Msg removeOrderDetail(@RequestParam String orderNumber) {
        orderDetailServiceImpl.removeOrderDetail(orderNumber);
        return Msg.success();
    }
}
