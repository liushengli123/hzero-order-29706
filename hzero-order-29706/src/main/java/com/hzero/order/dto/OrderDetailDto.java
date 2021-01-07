package com.hzero.order.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailDto{

    // 订单头信息
    private String orderNumber;
    private String companyName;
    private String customerName;
    private Date orderDate;
    private String orderStatus;
    private String orderStatusMeaning;
    private Long soHeaderId;

    // 订单行信息
    private Long soLineId;
    private Long lineNumber;
    private String itemCode;
    private String itemDescription;
    private BigDecimal orderQuantity;
    private String orderQuantityUom;
    private BigDecimal unitSellingPrice;
    private BigDecimal lineAmount;
    private String description;
    private String addition1;
    private String addition2;
    private String addition3;
    private String addition4;
    private String addition5;


}
