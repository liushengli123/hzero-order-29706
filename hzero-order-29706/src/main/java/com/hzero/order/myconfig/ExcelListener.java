package com.hzero.order.myconfig;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hzero.order.dto.ExcelExportDto;
import org.apache.poi.ss.formula.functions.T;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelListener extends AnalysisEventListener <ExcelExportDto>{

    List<ExcelExportDto> list = new ArrayList<>();

    @Override
    public void invoke(ExcelExportDto excelExportDto, AnalysisContext context) {
        list.add(excelExportDto);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

    public List<ExcelExportDto> getData(){
        return list;
    }

}
