package com.anant.SpringbootJava_8.entity;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getSalary()-o2.getSalary());//ascending
	}
//	return (int) (o1.getSalary()-o2.getSalary());//descending order of salary
}
