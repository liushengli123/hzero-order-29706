package com.hzero.order.controller;


import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.Msg;
import com.hzero.order.dto.PageRequest;
import com.hzero.order.entity.Company;
import com.hzero.order.service.Impl.CompanyServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/v1")
public class CompanyController {

    @Resource
    private CompanyServiceImpl companyServiceImpl;

    @ApiOperation(value = "条件查询公司名")
    @GetMapping("/conditions")
    public Msg listOne(@RequestParam(required = false) String companyNumber,
                       @RequestParam(required = false) String companyName,
                       PageRequest pageRequest) {
        Company company = new Company();
        company.setCompanyNumber(companyNumber);
        company.setCompanyName(companyName);
        PageInfo<Company> pageInfo = companyServiceImpl.findCompanyByNameOrNumber(company,pageRequest);
        return Msg.success().add("pageInfo",pageInfo);
    }
}
