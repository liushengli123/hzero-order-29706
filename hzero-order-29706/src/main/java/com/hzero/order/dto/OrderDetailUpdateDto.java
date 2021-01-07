package com.hzero.order.dto;

import com.hzero.order.entity.Header;
import com.hzero.order.entity.Line;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@ApiModel("订单明细修改DTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailUpdateDto{
    private Header header;
    private List<Line> lines;

}
