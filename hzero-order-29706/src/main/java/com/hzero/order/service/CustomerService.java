package com.hzero.order.service;


import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Customer;


public interface CustomerService {

    PageInfo<Customer> findCustomerByNameOrNumber(Customer customer, Long companyId, PageRequest pageRequest);

}
