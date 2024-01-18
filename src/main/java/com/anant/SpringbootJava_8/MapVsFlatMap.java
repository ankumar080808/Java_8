package com.anant.SpringbootJava_8;

import java.util.List;
import java.util.stream.Collectors;

import com.anant.SpringbootJava_8.entity.Customer;
import com.anant.SpringbootJava_8.entity.CustomerDao;

public class MapVsFlatMap {

	public static void main(String[] args) {

		List<Customer> customers = CustomerDao.getAll();

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> customer.getEmail()
		// customer -> customer.getEmail() one to one mapping

		// <R> Stream<R> map(Function<? super T, ? extends R> mapper);

		// <R> is the type parameter representing the element type of the new stream
		// that will be returned.
		// Function<? super T, ? extends R> mapper is a functional interface
		// representing a function that
		// takes an element of the original stream (T)
		// and returns a transformed result (R)

		// So here its taking T of Customer type as input and returning R which is of
		// String type
		// as output.

		List<String> emails = customers.stream().map(Customer::getEmail).collect(Collectors.toList());
		System.out.println(emails);

		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		// customer -> customer.getPhoneNumbers() ->> one to many mapping

		List<List<String>> phoneNumbers = customers.stream().map(customer -> customer.getPhoneNumbers())
				.collect(Collectors.toList());
		System.out.println(phoneNumbers);

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> phone Numbers
		// customer -> customer.getPhoneNumbers() ->> one to many mapping

		// stream(): Converts the customers list into a stream of Customer objects.

		// .flatMap(customer -> customer.getPhoneNumbers().stream()): Applies the
		// flatMap operation to
		// transform each Customer object into a stream of phone numbers. The
		// getPhoneNumbers() method is assumed to return
		// a List<String> representing the phone numbers for a given customer. The
		// flatMap operation is used to flatten the nested streams
		// into a single stream of phone numbers.

//In the nested stream approach, you map each customer to a stream of phone numbers using 
//customer.getPhoneNumbers().stream(). Then, you use flatMap to flatten the nested streams into
//a single stream of phone numbers. Finally, you collect the results into a list.

		List<String> phones = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());

		System.out.println(phones);

	}

}
