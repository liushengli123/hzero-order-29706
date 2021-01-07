package com.hzero.order.controller;

import com.hzero.order.dto.Msg;
import com.hzero.order.entity.Line;
import com.hzero.order.mapper.LineMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.annotation.Resource;

@RestController
@RequestMapping("/V5")
public class LineController {

    @Resource
    LineMapper lineMapper;

    @ApiOperation(value = "新增销售订单行")
    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "soHeaderId", value = "订单头id", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "itemId", value = "物料ID", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "orderQuantity", value = "订单数量", dataType = "long", required = true, paramType = "query"),
            @ApiImplicitParam(name = "orderQuantityUom", value = "产品单位", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "unitSellingPrice", value = "销售单价", dataType = "long", required = true, paramType = "query"),
            @ApiImplicitParam(name = "addition1", value = "附件信息1", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "addition2", value = "附件信息2", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "addition3", value = "附件信息3", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "addition4", value = "附件信息4", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "addition5", value = "附件信息5", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "description", value = "备注", dataType = "String", paramType = "query"),
    })
    public Msg create(@ApiIgnore Line line) {
        Long soHeaderId = line.getSoHeaderId();
        Long maxLineNumber = lineMapper.getMaxLineNumber(soHeaderId);
        if (maxLineNumber == null) {
            line.setLineNumber(1L);
        } else {
            line.setLineNumber(maxLineNumber + 1L);
        }
        lineMapper.insert(line);
        return Msg.success();
    }

    @ApiOperation(value = "修改销售订单行")
    @PutMapping
    public Msg update(@RequestBody Line line) {
       lineMapper.updateById(line);
        return Msg.success();
    }

    @ApiOperation(value = "删除销售订单行")
    @DeleteMapping
    public Msg remove(@RequestParam Long soLineId) {
        lineMapper.deleteBySoLineId(soLineId);
        return Msg.success();
    }
}
