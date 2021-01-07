package com.hzero.order.controller;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.Msg;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Customer;
import com.hzero.order.service.Impl.CustomerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@RestController
@RequestMapping("/v2")
public class CustomerController {

    @Resource
    private CustomerServiceImpl customerServiceImpl;

    @ApiOperation(value = "条件查询客户名")
    @GetMapping("/conditions")
    public Msg listOne(@RequestParam(required = false) String customerNumber,
                       @RequestParam(required = false) String customerName,
                       @RequestParam(required = false) Long companyId,
                       PageRequest pageRequest) {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setCustomerNumber(customerNumber);
        PageInfo<Customer> pageInfo= customerServiceImpl.findCustomerByNameOrNumber(customer,companyId,pageRequest);
        return Msg.success().add("pageInfo", pageInfo);
    }
}
