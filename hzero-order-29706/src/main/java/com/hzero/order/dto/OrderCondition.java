package com.hzero.order.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderCondition {
    @ApiModelProperty(value = "公司id")
    private Long companyId;
    @ApiModelProperty(value = "客户id")
    private Long customerId;
    @ApiModelProperty(value = "订单编号")
    private String orderNumber;
    @ApiModelProperty(value = "物料id")
    private Long itemId;

    @ApiModelProperty(value = "订单状态", allowableValues = "NEW,SUBMITTED,APPROVED,REJECTED,CLOSED")
    private String orderStatus;
}
