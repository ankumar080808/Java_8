package com.anant.SpringbootJava_8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.anant.SpringbootJava_8.entity.Customer;
import com.anant.SpringbootJava_8.entity.CustomerDao;

public class OptionalDemo {

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer(101, "john", null, Arrays.asList("397937955", "21654725"));

		// empty method
		// The Optional.empty() method is a convenient way to obtain an empty Optional
		// without specifying a particular type, as the type is inferred from the
		// context or usage.
		// It's commonly used in situations where you want to represent the absence of a
		// value.

		Optional<Object> emptyOptional = Optional.empty();
		//System.out.println(emptyOptional);

		// of method
		// return new Optional<>(Objects.requireNonNull(value));: This line creates a
		// new instance of the Optional class, wrapping the provided value. The
		// Objects.requireNonNull(value) ensures that the provided value is not null.
//If value is null, it throws a NullPointerException.
		//Optional<String> emailOptional = Optional.of(customer.getEmail());
		       
		//System.out.println(emailOptional.get());

		// OfNullabe method
//The ofNullable method is useful when you want to create an Optional instance that may or may not contain a value,
		//and it gracefully handles the case where the provided value is null. 
		//If the value is null, it returns an empty Optional; otherwise, it returns an Optional containing the non-null value.

		Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
		
		if(emailOptional2.isPresent()){
            System.out.println(emailOptional2.get());
        }
		
		System.out.println(emailOptional2.orElse("default@email.com"));
		System.out.println(emailOptional2.orElseGet(()->"Anant@gmail.com"));

	   // System.out.println(emailOptional2.orElseThrow(()->new IllegalArgumentException("email not present")));
    
		System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()->"default email..."));
		// Customer cus= OptionalDemo.getCustomerByEmailId("anant@gmail.com");
		// System.out.println(cus);

	}

//customers.stream().filter(customer -> customer.getEmail().equals(email)).findAny()
//will return an Optional<Customer>. The findAny() operation returns an arbitrary element of 
//the filtered stream (or an empty Optional if the stream is empty)
//if there is at least one customer in the stream whose email matches the specified email, the Optional will contain one of those customers.

//If there are multiple customers with matching emails, findAny() is non-deterministic and can return any of them.

//If there are no customers with a matching email, the Optional will be empty.

//You can use methods like orElse() or orElseGet() on the Optional to handle

	// Optional<String> optionalValue = Optional.of("Hello");

//String result = optionalValue.orElseThrow(() -> new IllegalStateException("Value not present"));
// If a value is present, it returns "Hello"
// If no value is present, it throws an IllegalStateException with the specified message

	public static Customer getCustomerByEmailId(String email) throws Exception {

		List<Customer> customers = CustomerDao.getAll();

		return customers.stream().filter(customer -> customer.getEmail().equals(email)).findAny()
				.orElseThrow(() -> new Exception("no customer present with this email id"));
	}

}
