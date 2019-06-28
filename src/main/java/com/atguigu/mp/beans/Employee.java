package com.atguigu.mp.beans;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @TableName 
 *   value :指定表名 默认是实体类的类名小写 
 *
 */
//@TableName("tbl_employee")
public class Employee {

	/**
	 * @TableId:
	 * 	value 指定表中主键的列名
	 *  type 指定主键生成策略
	 */
	//@TableId(value="id",type=IdType.AUTO)
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender;
	private Integer age;

	public Employee() {
		super();
	}

	public Employee(String lastName, String email, Integer gender, Integer age) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", age="
				+ age + "]";
	}

}
