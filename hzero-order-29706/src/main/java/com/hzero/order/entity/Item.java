package com.hzero.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "hodr_item")
@ApiModel("物料")
public class Item{
    @ApiModelProperty("表ID，主键，供其他表做外键")
    @TableId
    private Long itemId;
    @ApiModelProperty(value = "物料编码",required = true)
    @NotBlank
    private String itemCode;
    @ApiModelProperty(value = "物料单位",required = true)
    @NotBlank
    private String itemUom;
    @ApiModelProperty(value = "物料描述",required = true)
    @NotBlank
    private String itemDescription;
    @ApiModelProperty(value = "可销售标识",required = true)
    @NotNull
    private Integer saleableFlag;
    @ApiModelProperty(value = "生效起始时间")
    private Date startActiveDate;
    @ApiModelProperty(value = "生效结束时间")
    private Date endActiveDate;
    @ApiModelProperty(value = "启用标识",required = true)
    @NotNull
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
//
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Long lastUpdatedBy;
}
