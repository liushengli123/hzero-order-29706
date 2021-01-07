package com.hzero.order;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.hzero.order.dto.ExcelExportDto;
import com.hzero.order.mapper.ExcelExportMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderApplicationTests {

	@Resource
	DataSource dataSource;
	@Test
	void contextLoads() throws SQLException {
		System.out.println(""+dataSource.getConnection());
	}


}
