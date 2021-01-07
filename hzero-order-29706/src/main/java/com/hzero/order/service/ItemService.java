package com.hzero.order.service;


import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Item;

public interface ItemService {

    PageInfo<Item> findItemByCondition(Item item, PageRequest pageRequest);

}
