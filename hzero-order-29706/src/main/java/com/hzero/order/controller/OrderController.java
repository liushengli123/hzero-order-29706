package com.hzero.order.controller;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.*;
import com.hzero.order.entity.Header;
import com.hzero.order.service.Impl.OrderServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/v6")
public class OrderController {

    @Resource
    OrderServiceImpl orderServiceImpl;

    @ApiOperation(value = "销售订单汇总")
    @GetMapping
    public Msg orderList(OrderCondition orderCondition,
                         PageRequest pageRequest) {
        PageInfo<Order> pageInfo = orderServiceImpl.selectOrdersByCondition(orderCondition, pageRequest);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @ApiOperation(value = "订单明细导出")
    @GetMapping("/export")
    public void exportExcel(OrderCondition orderCondition,HttpServletResponse response){
       orderServiceImpl.exportExcel(orderCondition,response);
    }

    @ApiOperation(value = "订单明细导入")
    @PostMapping("/import")
    public Msg importExcel(MultipartFile multipartFile) throws IOException {
        orderServiceImpl.importExcel(multipartFile);
        return Msg.success();
    }

    @ApiOperation("提交订单")
    @PutMapping("/submitOrder")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", value = "订单状态", required = true, dataType = "String", paramType = "query", allowableValues = "SUBMITED")
    })
    public Msg submitOrder(@RequestParam("订单头id") Long headerId, String orderStatus) {
        Header header = orderServiceImpl.submitOrder(headerId,orderStatus);
        return Msg.success().add("header",header);
    }


    @ApiOperation("审批订单")
    @PutMapping("/approveOrder")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", required = true,value = "订单状态",  dataType = "String", paramType = "query", allowableValues = "APPROVED,REJECTED")
    })
    public Msg approveOrder(@RequestParam("订单头id") Long headerId, String orderStatus) {
        Header header = orderServiceImpl.approveOrder(headerId,orderStatus);
        return Msg.success().add("header",header);
    }
}
