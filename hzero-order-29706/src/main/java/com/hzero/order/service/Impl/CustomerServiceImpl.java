package com.hzero.order.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Customer;
import com.hzero.order.mapper.CustomerMapper;
import com.hzero.order.service.CustomerService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerMapper customerMapper;

    @Override
    public PageInfo<Customer> findCustomerByNameOrNumber(Customer customer, Long companyId, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getSize());
        List<Customer> customerList = customerMapper.findCustomerByNameOrNumber(customer, companyId);
        return new PageInfo<>(customerList);
    }

}
