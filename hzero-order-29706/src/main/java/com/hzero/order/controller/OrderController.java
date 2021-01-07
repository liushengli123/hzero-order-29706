package com.hzero.order.controller;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.*;
import com.hzero.order.service.Impl.OrderServiceImpl;
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
}
