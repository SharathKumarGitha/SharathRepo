package com.java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExamples {

	static Consumer<EmpDetails> c1 = emp -> System.out.println(emp);

	static Consumer<EmpDetails> c2 = System.out::println;

	static Consumer<EmpDetails> c3 = EmpDetails::printHobbies;

	static Predicate<EmpDetails> p1 = EmpDetails::checkName;
	
	static Function<String, String> f1=String::toUpperCase;
	
	

	public static void main(String[] args) {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c3);

		System.out.println("===================");

		list.stream().filter(p1).forEach(emp -> System.out.println(emp));

	}

}
