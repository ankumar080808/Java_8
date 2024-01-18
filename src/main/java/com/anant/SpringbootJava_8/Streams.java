package com.anant.SpringbootJava_8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.anant.SpringbootJava_8.entity.Employee;
import com.anant.SpringbootJava_8.entity.EmployeeDao;
import com.anant.SpringbootJava_8.entity.MyComparator;

public class Streams {
	
	
	
	public static void main(String args [])
	{
		
		Map<Integer,String> map=new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		map.forEach((key,value)->System.out.println(key+" "+value));
		
		
		map.entrySet().stream().forEach(obj->System.out.println(obj));
		map.entrySet().stream().filter(k->k.getKey()%2==0).forEach(e->System.out.println(e));
		
		List<String> list1=Arrays.asList("Prashant","Anant","Manik");
		
		list1.stream().filter(t->t.startsWith("P")).forEach(t->System.out.println(t));
		
		
		//filter employess on basis of salary
		
		List<Employee> empss=EmployeeDao.getEmployes().stream().filter(emp->emp.getSalary()>20000)
				.collect(Collectors.toList());
     	System.out.println(empss);
     	
     	List<Integer> list2= Arrays.asList(10,39,23,89,45);
     	Collections.sort(list2);//Ascending
     	System.out.println(list2);
     	Collections.reverse(list2);//Descending
     	System.out.println(list2);
     	
     	list2.stream().sorted().forEach(t->System.out.println(t+" "));//ascending
     	list2.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.println(t+" "));//descending
     	
     	List<Employee> emps1=EmployeeDao.getEmployes();
     	Collections.sort(emps1, new MyComparator());
     	//System.out.println(emps1);
     	Collections.sort(emps1, new Comparator<Employee>()
     			{

     		@Override
     		public int compare(Employee o1, Employee o2) {
     			// TODO Auto-generated method stub
     			return (int) (o2.getSalary()-o1.getSalary());//ascending
     		}
     		
     			});
     	
     	//System.out.println(emps1);
    	Collections.sort(emps1,(o1,o2)->(int) (o1.getSalary()-o2.getSalary()));
    	//System.out.println(emps1);
    	
    	//using stream Api
    	
    	//emps1.stream().sorted((o1,o2)->(int) (o1.getSalary()-o2.getSalary())).forEach(System.out::print);
    	//emps1.stream().sorted(Comparator.comparing(emp->emp.getSalary())).forEach(System.out::println);
    	//emps1.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
    	emps1.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
	}

}
