package com.hzero.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("订单头")
@TableName(value = "hodr_so_header")
public class Header{
    @ApiModelProperty(value = "表ID，主键，供其他表做外键")
    @TableId
    private Long soHeaderId;
    @ApiModelProperty(value = "订单编号",required = true)
    private String orderNumber;
    @ApiModelProperty(value = "公司ID",required = true)
    private Long companyId;
    @TableField(fill = FieldFill.INSERT)
    private Date orderDate;
    @ApiModelProperty(value = "订单状态",hidden  = true)
    private String orderStatus;
    @ApiModelProperty(value = "客户id",required = true)
    private Long customerId;

//    @ApiModelProperty(value = "订单版本",hidden  = true)
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
