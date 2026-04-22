package com.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmpDetailsPractice {

	static Consumer<String> c1 = str -> System.out.println("this is " + str);

	static Consumer<String> c2 = str -> System.out.println(str.toUpperCase());

	static Consumer<EmpDetails> emp1 = emp -> System.out.println(emp.getEname());

	static Consumer<EmpDetails> emp2 = emp -> System.out.println(emp.getHobbies());

	static BiConsumer<Integer, String> bc1 = (id, name) -> System.out.println("eid is " + id + " and ename is " + name);

	static Predicate<String> p1 = str -> str.startsWith("sh");

	static Predicate<EmpDetails> p2 = emp -> emp.getEname().startsWith("s");

	static Predicate<EmpDetails> p3 = emp -> emp.getSalary() > 25000;

	static BiPredicate<Integer, String> bp1 = (b1, b2) -> b1 > 100 && b2.startsWith("s");

	static Function<String, String> f1 = str -> str.concat("kumar");

	static Function<Integer, Boolean> f2 = value -> value > 10;

	static Function<List<EmpDetails>, List<String>> f4 = EmpDetails::getAllNames;

	static Function<List<EmpDetails>, List<String>> f6 = list -> list.stream().map(EmpDetails::getEname)
			.collect(Collectors.toList());

	static Function<List<EmpDetails>, Map<String, List<String>>> f3 = emp -> {
		Map<String, List<String>> map = new HashMap();

		emp.forEach(empdet -> {

			if (PredicateClassDemo.p4.test(empdet)) {
				map.put(empdet.getEname(), empdet.getHobbies());
			}

		});

		return map;

	};

	public static void printNames() {

		List<EmpDetails> list_of_emp = EmpDatabase.getAllEmpDet();

		list_of_emp.forEach(emp1);

	}

	public static void printHobbies() {
		List<EmpDetails> list_of_emp = EmpDatabase.getAllEmpDet();

		list_of_emp.forEach(emp2);
	}

	public static void printHobbiesAndNamesWithCondition() {

		List<EmpDetails> list_of_emp = EmpDatabase.getAllEmpDet();

		list_of_emp.forEach(emp -> {

			if (emp.getEname().startsWith("s")) {
				emp1.andThen(emp2).accept(emp);
			}
		});

	}

	public static void usingBiConsumer() {

		List<EmpDetails> list_of_emp = EmpDatabase.getAllEmpDet();

		list_of_emp.forEach(emp -> {

			if (emp.getEname().startsWith("s")) {
				bc1.accept(emp.getEid(), emp.getEname());
			}
		});

	}

	public static void checkNameWithS() {
		System.out.println(p1.test("sam"));
	}

	public static void printNamesWithNameCondition() {

		List<EmpDetails> list_of_emp = EmpDatabase.getAllEmpDet();

		List<EmpDetails> list_with_emp = list_of_emp.stream().filter(p2).collect(Collectors.toList());

		System.out.println(list_of_emp);

	}

	public static void printTwoPredicatesWithCondition() {

		List<EmpDetails> list_of_emp = EmpDatabase.getAllEmpDet();

		list_of_emp.forEach(emp -> {

			if (p2.and(p3).test(emp)) {
				System.out.println(emp);
			}
		});

	}

	public static void printUsingBiPredicate() {

		List<EmpDetails> list_of_emp = EmpDatabase.getAllEmpDet();

		list_of_emp.forEach(emp -> {

			if (bp1.test(emp.getEid(), emp.getEname())) {
				System.out.println(emp);
			}
		});

	}

	public static void usingFunctionWithCondition() {

		System.out.println("usingFunctionWithCondition.....");
		System.out.println(f1.apply("sharath"));

		System.out.println(f2.apply(1000));

		List<EmpDetails> list_with_emp = EmpDatabase.getAllEmpDet();

		System.out.println(f3.apply(list_with_emp));

		System.out.println("===================================");

		System.out.println(f4.apply(list_with_emp));
	}

	public static void IntStreamOperations() {

		System.out.println("working with instream operations......");

		int sum = IntStream.rangeClosed(1, 50).sum();

		System.out.println("sum of numbers is ...." + sum);

		double avg = IntStream.rangeClosed(1, 50).average().getAsDouble();

		System.out.println("average of numbers is ......" + avg);

		List<Integer> list_with_int = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());

		System.out.println(list_with_int);

		int sum_with_skip = list_with_int.stream().mapToInt(e -> e).skip(10).sum();

		System.out.println("count with skip ......." + sum_with_skip);

		Integer sum_with_reduce = list_with_int.stream().reduce((a, b) -> a + b).get();

		System.out.println("sum with reduce function......." + sum_with_reduce);

		Integer max_number = list_with_int.stream().reduce((a, b) -> a > b ? a : b).get();

		System.out.println("max number is ......" + max_number);

		Integer max = list_with_int.stream().reduce(Integer::max).get();

		System.out.println("max numbber is....." + max);

	}

	public static void main(String[] args) {

		c1.accept("sharath");

		System.out.println("================================");

		c2.accept("mahesh babu");

		System.out.println("=============================");

		printNames();

		System.out.println("==================================");

		printHobbies();

		System.out.println("===================================");

		printHobbiesAndNamesWithCondition();

		System.out.println("==========================");

		usingBiConsumer();

		System.out.println("==============================");

		checkNameWithS();

		System.out.println("==========================");

		printNamesWithNameCondition();

		System.out.println("=================================");

		printTwoPredicatesWithCondition();

		System.out.println("==================================");

		printUsingBiPredicate();

		System.out.println("======================================");

		usingFunctionWithCondition();

		System.out.println("================================");

		IntStreamOperations();

	}

}
