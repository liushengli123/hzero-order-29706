package com.hzero.order.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {


    List<Item> findItemByCondition(Item item);


    Long selectItemIdByItemCode(String itemCode);

}
