package com.hzero.order;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;


@SpringBootTest
public class OrderApplicationTests {

	@Resource
	DataSource dataSource;
	@Test
	void contextLoads() throws SQLException {
		System.out.println(""+dataSource.getConnection());
	}


}
