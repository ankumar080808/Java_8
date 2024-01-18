package com.anant.SpringbootJava_8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_Demo implements Consumer<Integer> {

	
	
	public static void main(String args [])
	{
		
		Consumer<Integer> con=(t)->{
			
			System.out.println(t);
		};

		con.accept(10);
		
		
		Consumer<Integer> cons=t->System.out.println(t);
		cons.accept(120);
		
		
		List<Integer> list1=Arrays.asList(1,2,3,4,5);
		
		list1.stream().forEach(cons);
		list1.stream().forEach(t->System.out.println(t));

	}
	
	
	
	@Override
	public void accept(Integer t) {
		// TODO Auto-generated method stub
		
	}

	

}
