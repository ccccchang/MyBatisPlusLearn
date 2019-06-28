package com.atguigu.mp.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;

public class Test01 {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
	
	@Test
	public void testDataSource() throws Exception{
		
		DataSource dataSource = ioc.getBean(DataSource.class);
		
		System.out.println(dataSource.getConnection());
		
	}
	
	/**
	 * 测试插入
	 */
	@Test
	public void insert() {
//		System.out.println(employeeMapper);
		
		Employee employee = new Employee("张三", "zhangsan@qq.com", 1, 15);
		
		Integer result = employeeMapper.insert(employee);
		
		System.out.println(result);
	}
	
	
	
}
