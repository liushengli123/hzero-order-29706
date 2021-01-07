package com.hzero.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;


@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> findCustomerByNameOrNumber(@Param("customer") Customer customer, @Param("companyId") Long companyId);


    Long selectCustomerIdByCustomerNumber(@Param("customerNumber") String customerNumber);
}
