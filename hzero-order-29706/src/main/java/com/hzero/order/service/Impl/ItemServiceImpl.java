package com.hzero.order.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Item;
import com.hzero.order.mapper.ItemMapper;
import com.hzero.order.service.ItemService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    ItemMapper itemMapper;

    @Override
    public PageInfo<Item> findItemByCondition(Item item, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getSize());
        List<Item> itemList = itemMapper.findItemByCondition(item);
        return new PageInfo<>(itemList);
    }

}
