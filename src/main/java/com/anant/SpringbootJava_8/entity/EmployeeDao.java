package com.anant.SpringbootJava_8.entity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static List<Employee> getEmployes()
	{
		List<Employee> emps=new ArrayList<>();
		
		emps.add(new Employee(1,"Anant","HOD",20000));
		emps.add(new Employee(2,"Sachin","Physics",30000));
		emps.add(new Employee(3,"Vinita","Chemistry",40000));
		
		return emps;
		
		
	}
}
