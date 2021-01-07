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
public class Order{
    private String orderNumber;
    private String companyName;
    private String customerName;
    private Date orderDate;
    private String orderStatus;
    private String orderStatusMeaning;
    private BigDecimal orderAmount;
}
