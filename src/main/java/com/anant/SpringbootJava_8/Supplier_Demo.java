package com.anant.SpringbootJava_8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Supplier_Demo implements Supplier<String>{

	

	
	public static void main(String args [])
	{
		
		Supplier<String> supp=()->{
			
			return "Hey Techie";
		};
		
		System.out.println(supp.get());
		
		Supplier<String> supp1=()-> "Hi Anant";
		System.out.println(supp1.get());
		
		
		List<String> list1=Arrays.asList("a","b");
		List<String> list2=Arrays.asList();
		System.out.println(list2.stream().findAny().orElseGet(()-> "Hi Anant"));
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}
        
	
}
