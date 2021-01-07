package com.hzero.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzero.order.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface CompanyMapper extends BaseMapper<Company> {

    Long getById(String companyNumber);

    List<Company> findCompanyByNameOrNumber(Company company);
}
