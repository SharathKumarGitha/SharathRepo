package com.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AgainPractice {

	static Consumer<String> c1 = str -> System.out.println("this is ........ " + str);

	static Consumer<Integer> c2 = integer -> System.out.println(integer + 10);

	static Consumer<String> c3 = str -> System.out.println("this is ...." + str.toUpperCase());

	static Consumer<EmpDetails> c4 = emp -> System.out.println(emp);

	static Consumer<EmpDetails> c5 = emp -> System.out.println("names of emp....." + emp.getEname());

	static Consumer<EmpDetails> c6 = emp -> System.out.println("hobbies of emp....." + emp.getHobbies());

	static Consumer<EmpDetails> c = emp -> System.out
			.println("name of emp....." + emp.getEname() + ", hobbies of emp....." + emp.getHobbies());

	static Function<String, String> f1 = str -> str.toUpperCase();

	static Function<List<EmpDetails>, Map<String, List<String>>> f2 = emp -> {

		Map<String, List<String>> hm = new HashMap();

		emp.forEach(e -> {

			if (e.getEname().startsWith("s")) {
				hm.put(e.getEname(), e.getHobbies());
			}

		});

		return hm;

	};

	static Predicate<Integer> p1 = a1 -> a1 % 2 == 0;

	static Predicate<String> p2 = str -> str.startsWith("s");

	static Predicate<EmpDetails> p3 = emp -> emp.getEname().startsWith("s");

	static Predicate<EmpDetails> p4 = emp -> emp.getEid() > 100;

	public static void usingPredicateMethod() {
		if (p1.test(10)) {
			System.out.println("yes number divided with 2");
		} else {
			System.out.println("else number not divided");
		}

		if (p2.test("sharath")) {
			System.out.println("yes name starts with ");
		} else {
			System.out.println("it is not starts with s");
		}

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(emp -> {

			if (p3.test(emp)) {
				System.out.println("list of employee..." + emp);
			}
		});
	}

	static BiFunction<List<EmpDetails>, Predicate<EmpDetails>, Map<String, Integer>> bf1 = (emp, emppredicate) -> {

		Map<String, Integer> map = new HashMap();

		emp.forEach(e1 -> {

			if (emppredicate.test(e1)) {
				map.put(e1.getEname(), e1.getEid());
			}
		});

		return map;

	};

	public static void printNormalConsumer() {
		AgainPractice.c1.accept("sharath");

		AgainPractice.c3.accept("sharath");
	}

	public static void printEmpDet() {
		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c4);

		list.forEach(c5);

		list.forEach(c6);

	}

	public static void printConsumerWithCondition() {
		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(emp ->

		{
			if (emp.getEname().startsWith("s")) {
				c5.andThen(c6).accept(emp);
			}

		});

	}

	public static void usingIntStream() {
		int sum = IntStream.rangeClosed(1, 50).sum();

		System.out.println("sum of 50 integers...." + sum);

		double avg = IntStream.rangeClosed(1, 50).average().getAsDouble();

		System.out.println("avg of numbers....." + avg);

		int max_value = IntStream.rangeClosed(1, 50).max().getAsInt();

		System.out.println("max value is ......" + max_value);

		List<Integer> stream_int = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());

		System.out.println("after boxed list......" + stream_int);

		int sum_using_mapToint = stream_int.stream().mapToInt(e -> e).sum();

		System.out.println("using maptoInt function...." + sum_using_mapToint);

		int sum_using_reduce = stream_int.stream().reduce(10000, (a, b) -> a + b).intValue();

		System.out.println("sum using reduce....." + sum_using_reduce);

	}

	public static void usingInstreamSecondTime() {
		int sum = IntStream.rangeClosed(1, 50).map(Integer::new).sum();

		System.out.println(sum);

		boolean condition = IntStream.rangeClosed(1, 50).anyMatch(e -> e % 2 == 0);

		if (condition) {
			System.out.println("yes numbers are dividing with 2");
		} else {
			System.out.println("numbers are not dividing with 2");
		}

		double avg = IntStream.rangeClosed(1, 50).average().getAsDouble();

		System.out.println("avg of first 50 numbers is ....." + avg);

		int max_number = IntStream.rangeClosed(1, 50).max().getAsInt();

		System.out.println("max number is ....." + max_number);

		double avg_using_double = IntStream.rangeClosed(1, 50).asDoubleStream().average().getAsDouble();

		System.out.println(avg_using_double);

		List<Integer> list = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());

		int min_value = list.stream().reduce(Integer::min).get().intValue();

		System.out.println("minimum value is ......." + min_value);

		System.out.println("------------------------------------");

		List<EmpDetails> list_with_emp = EmpDatabase.getAllEmpDet();

		System.out.println(list_with_emp);

		List<String> hobbies = list_with_emp.stream().map(EmpDetails::getHobbies).flatMap(List::stream).distinct()
				.collect(Collectors.toList());

		System.out.println(hobbies);

		String result = hobbies.stream().collect(Collectors.joining(","));

		System.out.println(result);

		EmpDetails emp_with_highest_sal = list_with_emp.stream()
				.reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2).get();

		System.out.println("highest salary emp is....." + emp_with_highest_sal);

		List<EmpDetails> list_with_asc_names = list_with_emp.stream().sorted(Comparator.comparing(EmpDetails::getEname))
				.collect(Collectors.toList());

		System.out.println("list with asc names..." + list_with_asc_names);

		System.out.println("-----------------------------------------------");

		List<EmpDetails> list_with_dsc_names =

				list_with_emp.stream().sorted(Comparator.comparing(EmpDetails::getEname).reversed())
						.collect(Collectors.toList());

		System.out.println("list with dsc names..." + list_with_dsc_names);

		Map<String, Integer> names_with_length = list_with_emp.stream().map(EmpDetails::getEname)
				.map(String::toUpperCase).collect(Collectors.toMap(e -> e, String::length));

		System.out.println("print map with length....." + names_with_length);

		boolean using_any_match = list_with_emp.stream().map(EmpDetails::getEname).anyMatch(str -> str.startsWith("s"));

		System.out.println("yes some names starting with s......" + using_any_match);

		List<String> names_with_limit = list_with_emp.stream().map(EmpDetails::getEname).limit(2)
				.collect(Collectors.toList());

		System.out.println("names with limit...." + names_with_limit);

		List<Integer> list_with_int = Stream.iterate(1, x -> x * 2).limit(10).collect(Collectors.toList());

		System.out.println("using stream with iterate method......." + list_with_int);

		Map<String, List<EmpDetails>> using_groupingby = list_with_emp.

				stream().collect(Collectors.groupingBy(EmpDetails::getGender));

		System.out.println("using grouping by in first condition ......" + using_groupingby);

		Map<String, List<EmpDetails>> using_groupingby2 = list_with_emp.stream()
				.collect(Collectors.groupingBy(emp -> emp.getSalary() > 30000 ? "outstanding" : "average"));

		System.out.println("second condition used for map..." + using_groupingby2);

		Map<String, Integer> third_condition_using = list_with_emp.

				stream().collect(Collectors.groupingBy(EmpDetails::getGender,

						Collectors.summingInt(EmpDetails::getEid)));

		System.out.println("third condition using grouping by....." + third_condition_using);

		Map<Boolean, List<EmpDetails>> fourth_condition_partition_by = list_with_emp.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getEname().startsWith("s")));

		System.out.println("fourth condition using partioning......." + fourth_condition_partition_by);

	}

	public static void printSingleLine() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c);

	}

	public static void printConsumerUsingAndThen() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c5.andThen(c6));

	}

	public static void usingMap() {

		System.out.println(f2.apply(EmpDatabase.getAllEmpDet()));

	}

	static Consumer<EmpDetails> c22 = EmpDetails::printHobbies;

	public static void main(String[] args) {

		printNormalConsumer();

		System.out.println("=======================");

		printEmpDet();

		System.out.println("===========================");

		printConsumerWithCondition();

		System.out.println("=========================");

		printConsumerUsingAndThen();

		System.out.println("=================================");

		printSingleLine();

		System.out.println("=================================");

		usingMap();

		System.out.println("=========================");

		usingPredicateMethod();

		System.out.println("=========================");

		System.out.println(bf1.apply(EmpDatabase.getAllEmpDet(), p3.and(p4)));

		System.out.println("=========================");

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c22);

		System.out.println("========================");

		usingIntStream();

		System.out.println("====================");

		usingInstreamSecondTime();

	}

}
