package com.hzero.order.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExcelExportDto{
    @ExcelProperty(value = "order_number",index = 0)
    private String orderNumber;
    @ExcelProperty(value = "company_number",index = 1)
    private String companyNumber;
    @ExcelProperty(value = "order_date",index = 2)
    private Date orderDate;
    @ExcelProperty(value = "order_status",index = 3)
    private String orderStatus;
    @ExcelProperty(value = "customer_number",index = 4)
    private String customerNumber;
    @ExcelProperty(value = "line_number",index = 5)
    private Long lineNumber;
    @ExcelProperty(value = "item_code",index = 6)
    private String itemCode;
    @ExcelProperty(value = "order_quantity",index = 7)
    private BigDecimal orderQuantity;
    @ExcelProperty(value = "order_quantity_uom",index = 8)
    private String orderQuantityUom;
    @ExcelProperty(value = "unit_selling_price",index = 9)
    private BigDecimal unitSellingPrice;
    @ExcelProperty(value = "description",index = 10)
    private String description;
    @ExcelProperty(value = "addition1",index = 11)
    private String addition1;
    @ExcelProperty(value = "addition2",index = 12)
    private String addition2;
    @ExcelProperty(value = "addition3",index = 13)
    private String addition3;
    @ExcelProperty(value = "addition4",index = 14)
    private String addition4;
    @ExcelProperty(value = "addition5",index = 15)
    private String addition5;
}
