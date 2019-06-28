package com.atguigu.mp.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.plugins.Page;

public class Test01 {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
	
	@Test
	public void testDataSource() throws Exception{
		
		DataSource dataSource = ioc.getBean(DataSource.class);
		
		System.out.println(dataSource.getConnection());
		
	}
	
	/**
	 * 通用插入
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
	
	/**
	 * 通用更新
	 */
	@Test
	public void update() {
		
		Employee employee = new Employee();
		employee.setId(1);
//		employee.setLastName("Tom-Update");
//		//有哪个属性就改哪个属性，没有的属性不修改,id必须传
//		Integer result = employeeMapper.updateById(employee);
		
		employee.setAge(100);
		employee.setLastName("Tom-Update2");
		//没有的属性设为null
		Integer result = employeeMapper.updateAllColumnById(employee);
		
		System.out.println(result);
	}
	
	/**
	 * 通用查询
	 */
	@Test
	public void select() {
//		//根据id来查 单个
//		Employee emp = employeeMapper.selectById(1);
//		System.out.println(emp);
		
//		Employee employee = new Employee();
//		employee.setAge(100);
//		employee.setLastName("Tom-Update2");
//		//根据传入的对象的属性来查询，只能查一个
//		Employee emp = employeeMapper.selectOne(employee);
//		System.out.println(emp);
		
//		//查询多个 根据id的集合来查
//		List<Employee> emps = employeeMapper.selectBatchIds(Arrays.asList(1,2,3,4,5));
//		System.out.println(emps);
		
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "张三");
//		columnMap.put("age", "15");
//		//查询多个 根据列名的Map来查
//		List<Employee> emps = employeeMapper.selectByMap(columnMap);
//		System.out.println(emps);
		
		//分页查询，RowBound 可以用Page来实现 Page继承了它 Wrapper先不管 内存分页
		List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(2, 2),null);
		System.out.println(emps);
	} 
	
}
