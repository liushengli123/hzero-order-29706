package com.hzero.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("销售订单行")
@TableName(value = "hodr_so_line")
public class Line{
    @ApiModelProperty("表ID，主键，供其他表做外键")
    @TableId
    private Long soLineId;
    @ApiModelProperty(value = "订单头ID",required = true)
    private Long soHeaderId;
    @ApiModelProperty(value = "行号",required = true)
    private Long lineNumber;
    @ApiModelProperty(value = "产品ID",required = true)
    private Long itemId;
    @ApiModelProperty(value = "数量",required = true)
    private BigDecimal orderQuantity;
    @ApiModelProperty(value = "产品单位",required = true)
    private String orderQuantityUom;
    @ApiModelProperty(value = "销售单价",required = true)
    private BigDecimal unitSellingPrice;
    @ApiModelProperty(value = "备注")
    private String description;
    @ApiModelProperty(value = "附加信息1")
    private String addition1;
    @ApiModelProperty(value = "附加信息2")
    private String addition2;
    @ApiModelProperty(value = "附加信息3")
    private String addition3;
    @ApiModelProperty(value = "附加信息4")
    private String addition4;
    @ApiModelProperty(value = "附加信息5")
    private String addition5;
//    @Version
//    private Long objectVersionNumber;
//
//    @TableField(fill = FieldFill.INSERT)
//    private Date creationDate;
//
//    @TableField(fill = FieldFill.INSERT)
//    private Long createdBy;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date lastUpdateDate;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Long lastUpdatedBy;
}
