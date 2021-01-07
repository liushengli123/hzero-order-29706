package com.hzero.order.controller;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.Msg;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Item;
import com.hzero.order.service.Impl.ItemServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/v4")
public class ItemController {

    @Resource
    private ItemServiceImpl itemServiceImpl;

    @ApiOperation(value = "条件查询物料")
    @GetMapping("/conditions")
    public Msg listOne(@RequestParam(required = false) String itemCode,
                       @RequestParam(required = false) String itemDescription,
                       PageRequest pageRequest) {
        Item item = new Item();
        item.setItemCode(itemCode);
        item.setItemDescription(itemDescription);
        PageInfo<Item> pageInfo = itemServiceImpl.findItemByCondition(item, pageRequest);
        return Msg.success().add("pageInfo",pageInfo);
    }
}
