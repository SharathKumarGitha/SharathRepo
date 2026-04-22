package com.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionDemoWithEmpClass {

	static Function<String, String> f1 = str -> str.toUpperCase();

	static Function<String, String> f2 = str -> str.concat("kumar");

	static Function<Integer, Boolean> f3 = value -> value > 10;

	static Function<List<EmpDetails>, Map<String, List<String>>> f4 = emp -> {

		Map<String, List<String>> hm = new HashMap();

		emp.forEach(e -> {

			if (PredicateClassDemo.p5.test(e)) {
				hm.put(e.getEname(), e.getHobbies());
			}

		});

		return hm;
	};

	static Function<List<EmpDetails>, Map<String, Integer>> f5 = emp -> {

		Map<String, Integer> hm = new HashMap();

		emp.forEach(e -> {

			if (PredicateClassDemo.p4.test(e)) {
				hm.put(e.getEname(), e.getEid());
			}

		});

		return hm;
	};

	static BiFunction<List<EmpDetails>, Predicate<EmpDetails>, Map<String, Integer>> bf1 =

			(emps, emppredicate) -> {
				Map<String, Integer> hm = new HashMap<>();
				emps.forEach(emp -> {

					if (emppredicate.test(emp)) {
						hm.put(emp.getEname(), emp.getEid());
					}
				});

				return hm;
			};

	public static void withString() {
		System.out.println(f1.apply("sharath"));
	}

	public static void withTwoStringsCondition() {
		System.out.println(f1.andThen(f2).apply("sharath"));

		System.out.println("================");

		System.out.println(f1.compose(f2).apply("arun"));
	}

	public static void checkWithInteger() {
		System.out.println(f3.apply(100));
	}

	public static void main(String[] args) {

		withString();

		System.out.println("============================");

		withTwoStringsCondition();

		System.out.println("==============================");

		checkWithInteger();

		System.out.println("========================");

		List<EmpDetails> list_emp = EmpDatabase.getAllEmpDet();

		System.out.println(f4.apply(list_emp));

		System.out.println("=========================");

		System.out.println(f5.apply(list_emp));

		System.out.println("=========================");

		System.out.println(bf1.apply(list_emp, PredicateClassDemo.p4));

	}

}
