package com.hzero.order.controller;

import com.hzero.order.dto.Msg;
import com.hzero.order.entity.Header;
import com.hzero.order.mapper.HeaderMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/v3")
public class HeaderController {

    @Resource
    HeaderMapper headerMapper;

    @ApiOperation(value = "新增销售订单头")
    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", required = true, paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "customerId", required = true, paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "orderStatus", defaultValue = "NEW", paramType = "query", dataType = "String")
    })
    public Msg create(@ApiIgnore Header header) {
        header.setOrderDate(new Date());
        // 根据订单编码规则生成订单编号
        Random random = new Random(2);
        String orderNumber ="SO1907180000"+random;
        header.setOrderNumber(orderNumber);
        headerMapper.insert(header);
        return Msg.success();
    }

}
