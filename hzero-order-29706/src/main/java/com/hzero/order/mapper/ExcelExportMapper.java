package com.hzero.order.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.dto.ExcelExportDto;
import com.hzero.order.dto.OrderCondition;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ExcelExportMapper extends BaseMapper<ExcelExportDto> {

    List<ExcelExportDto> excelExport(OrderCondition condition);

}
