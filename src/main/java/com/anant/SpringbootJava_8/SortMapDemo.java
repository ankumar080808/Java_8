package com.anant.SpringbootJava_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.anant.SpringbootJava_8.entity.Employee;
import com.anant.SpringbootJava_8.entity.EmployeeDao;

public class SortMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> map = new HashMap<>();

		map.put("Anant", 8);
		map.put("Prashant", 7);
		map.put("Vinita", 5);

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

//		for(Entry<String,Integer> ent : entries)
//		{
//			System.out.println(ent.getKey()+" "+ ent.getValue());
//		}
//		

		// using stream api

		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		// now sort custom

		Map<Employee, Integer> empMap = new TreeMap<>(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return (int) (o2.getSalary() - o1.getSalary());
			}

		});

		List<Employee> employs = EmployeeDao.getEmployes();
		int i = 1;
		for (Employee emp1 : employs) {
			empMap.put(emp1, i++);

		}
		// System.out.println(empMap);

		// Sorting employee map using stream api

		empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
				.forEach(System.out::println);

		empMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		empMap.entrySet().stream().sorted(Map.Entry.<Employee, Integer>comparingByValue().reversed())
				.forEach(System.out::println);

	}

}
