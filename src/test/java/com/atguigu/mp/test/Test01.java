package com.atguigu.mp.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testDataSource() throws Exception{
		
		DataSource dataSource = ioc.getBean(DataSource.class);
		
		System.out.println(dataSource.getConnection());
		
		
	}
}
