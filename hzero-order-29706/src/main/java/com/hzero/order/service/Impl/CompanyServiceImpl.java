package com.hzero.order.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Company;
import com.hzero.order.mapper.CompanyMapper;
import com.hzero.order.service.CompanyService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    CompanyMapper companyMapper;

    @Override
    public PageInfo<Company> findCompanyByNameOrNumber(Company company, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getSize());
        List<Company> companyList = companyMapper.findCompanyByNameOrNumber(company);
        return new PageInfo<>(companyList);
    }

}
