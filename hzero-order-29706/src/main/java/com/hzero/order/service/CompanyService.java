package com.hzero.order.service;

import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Company;


public interface CompanyService{

    PageInfo<Company> findCompanyByNameOrNumber(Company company, PageRequest pageRequest);

}
