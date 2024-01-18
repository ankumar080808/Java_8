package com.anant.SpringbootJava_8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicate_Demo implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String args [])
	{
		
		Predicate<Integer> pre= (t)->{
			 
			 if(t%2==0)
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
			 
		 };
		 
		 System.out.println(pre.test(10));
		 
		 Predicate<Integer> pre1=t-> t%2==0;
		 System.out.println(pre1.test(5));
		 
		 List<Integer> list1=Arrays.asList(1,2,3,4,5);
		 list1.stream().filter(pre1).forEach(t->System.out.println("print even "+ t));
		 
		 List<Integer> list2=Arrays.asList(6,7,8,9,10);
		 list2.stream().filter(t->t%2==0).forEach(t->System.out.println("print even "+ t));
	}

}
