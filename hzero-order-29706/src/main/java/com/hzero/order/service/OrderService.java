package com.hzero.order.service;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.Order;
import com.hzero.order.dto.OrderCondition;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Header;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface OrderService {

    PageInfo<Order> selectOrdersByCondition(OrderCondition orderCondition, PageRequest pageRequest);

    void exportExcel(OrderCondition orderCondition, HttpServletResponse response);

    void importExcel(MultipartFile multipartFile) throws IOException;

    Header submitOrder(Long headerId, String orderStatus);

    Header approveOrder(Long headerId, String orderStatus);
}

