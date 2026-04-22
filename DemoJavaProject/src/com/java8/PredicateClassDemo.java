package com.java8;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateClassDemo {

	static Predicate<String> p1 = str -> str.startsWith("sh");

	static Predicate<Integer> p2 = a1 -> a1 % 2 == 0;

	static Predicate<Integer> p3 = a1 -> a1 % 5 == 0;

	static Predicate<EmpDetails> p4 = emp -> emp.getEname().startsWith("s");

	static Predicate<EmpDetails> p5 = emp -> emp.getSalary() > 25000;

	static BiPredicate<Integer, String> bp1 = (b1, b2) -> b1 > 100 && b2.startsWith("s");
	


	public static void checkWithString() {
		boolean b1 = p1.test("sharath");

		System.out.println(b1);
	}

	public static void checkWithTwoIntegersWithTwoPredicates() {
		boolean b3 = p2.and(p3).test(10);

		System.out.println(b3);
	}

	public static void checkWithTwoIntegersWithTwoPredicatesWithNegate() {
		boolean b3 = p2.and(p3).negate().test(10);

		System.out.println(b3);
	}

	public static void printEmpDetailsWithOneCondition() {
		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		List<EmpDetails> list_with_emp = list.stream().filter(p4).collect(Collectors.toList());

		System.out.println(list_with_emp);

	}

	public static void printWithTwoConditions() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(emp -> {

			if (p4.and(p5).test(emp)) {
				System.out.println(emp);

				ConsumerClassDemo.c3.accept(emp);
			}
		});

	}

	public static void printBiPredicateWithEmpDetails()

	{

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(emp -> {

			if (bp1.test(emp.getEid(), emp.getEname())) {
				ConsumerClassDemo.empDetCon.accept(emp);
			}
		});

	}

	public static void main(String[] args) {

		checkWithString();

		System.out.println("=========================");

		checkWithTwoIntegersWithTwoPredicates();

		System.out.println("===========================");

		checkWithTwoIntegersWithTwoPredicatesWithNegate();

		System.out.println("=========================");

		printEmpDetailsWithOneCondition();

		System.out.println("================================");

		printWithTwoConditions();

		System.out.println("========================");

		printBiPredicateWithEmpDetails();

	}

}
