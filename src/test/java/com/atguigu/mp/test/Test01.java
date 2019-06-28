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
	 * 
	 * 出现的异常1：没有在类上标注id生成策略 使用@TableId(type = IdType.Auto)
	 * 出现的异常2：没有标注表的名字，默认是类名第一个字母小写，使用@TableName("tbl_employee")
	 * 
	 * 由于不可能每次插入都设置主键策略和表名 MP有全局配置方式
	 * GlobalConfiguration 在Spring配置文件中加入这个bean 
	 * 注意 要在sqlSession那里引用 不然不会生效
	 * 
	 */
	@Test
	public void insert() {
//		System.out.println(employeeMapper);
		
//		Employee employee = new Employee();
//		employee.setAge(100);
		//插入操作
//		Integer result = employeeMapper.insert(employee);
		
		//插入操作2 全字段都会插 如果没有值就插入null
		Employee employee = new Employee();
		employee.setAge(11);
		employee.setGender(1);
		Integer result = employeeMapper.insertAllColumn(employee);
		
		System.out.println(result);
	}
	
	
	
}
