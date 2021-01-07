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
@TableName(value = "hodr_company")
@ApiModel("公司")
public class Company{
    @ApiModelProperty(value = "表ID，主键，供其他表做外键")
    @TableId
    private Long companyId;
    @ApiModelProperty(value = "公司编号",required = true)
    private String companyNumber;
    @ApiModelProperty(value = "公司名称",required = true)
    private String companyName;
//    @ApiModelProperty(value = "启用标识",required = true)
//    private Integer enabledFlag;

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
