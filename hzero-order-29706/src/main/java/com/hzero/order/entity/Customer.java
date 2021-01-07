package com.hzero.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "hodr_customer")
@ApiModel("客户")
public class Customer {
    @ApiModelProperty("表ID，主键，供其他表做外键")
    @TableId
    private Long customerId;
    @ApiModelProperty(value = "客户编号",required = true)
    private String customerNumber;
    @ApiModelProperty(value = "客户名称",required = true)
    private String customerName;
    @ApiModelProperty(value = "公司ID",required = true)
    private Long companyId;
    @ApiModelProperty(value = "启用标识",required = true)
    private Integer enabledFlag;
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

//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Long lastUpdatedBy;

}
