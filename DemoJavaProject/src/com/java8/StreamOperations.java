package com.java8;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	public static List<String> getHobbiesWithFlatMap() {
		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		return list.stream().map(EmpDetails::getHobbies).flatMap(List::stream).collect(Collectors.toList());

	}

	public static List<String> getHobbiesWithFlatMapWithDistinct() {
		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		return list.stream().map(EmpDetails::getHobbies).flatMap(List::stream).distinct().collect(Collectors.toList());

	}

	public static void usingReduceOperation() {

		List<Integer> list = EmpDatabase.getAllEmpDet().stream().map(EmpDetails::getEid).collect(Collectors.toList());

		Integer sum = list.stream().reduce((a, b) -> a + b).get();

		System.out.println(sum);

		System.out.println("===================");

		int sum2 = list.stream().reduce(10, (a, b) -> a + b).intValue();

		System.out.println("sum2 value is ...." + sum2);
		System.out.println("===================");

		Integer max_value = list.stream().reduce(Integer::max).get();

		System.out.println(max_value);
		System.out.println("===================");

		Integer max_value2 = list.stream().reduce((a, b) -> a > b ? a : b).get();

		System.out.println(max_value2);

		System.out.println("===================");

		List<EmpDetails> sort_asc_with_enames = EmpDatabase.getAllEmpDet().stream()
				.sorted(Comparator.comparing(EmpDetails::getEname)).collect(Collectors.toList());

		System.out.println("sort_asc_with_enames......" + sort_asc_with_enames);

		System.out.println("=============================");

		List<EmpDetails> sort_asc_with_enames_and_salary = EmpDatabase.getAllEmpDet().stream().

				sorted(Comparator.comparing(EmpDetails::getEname)
						.thenComparing(Comparator.comparing(EmpDetails::getSalary)))
				.collect(Collectors.toList());

		System.out.println("sort_asc_with_enames_and_salary" + sort_asc_with_enames_and_salary);

	}

	public static void withFilter() {

		List<String> list_with_condition = EmpDatabase.getAllEmpDet().stream()
				.filter(emp -> emp.getEname().startsWith("s")).filter(emp -> emp.getSalary() > 23000)
				.map(EmpDetails::getEname).collect(Collectors.toList());

		System.out.println(list_with_condition);
	}

	public static void usingFindFirstMethod() {
		EmpDetails details = EmpDatabase.getAllEmpDet().stream().filter(emp -> emp.getEname().startsWith("s"))
				.findFirst().get();

		List<EmpDetails> details2 = EmpDatabase.getAllEmpDet().stream().filter(emp -> emp.getEname().startsWith("s"))
				.skip(1).distinct().collect(Collectors.toList());

		System.out.println("finding first emp " + details);

		System.out.println(details2);

		boolean result = EmpDatabase.getAllEmpDet().stream().anyMatch(emp -> emp.getEname().startsWith("s"));

		if (result) {
			System.out.println("emp details name starts with s");
		} else {
			System.out.println("no names containing with s");
		}
	}

	public static void reduceMethodEmoDetClass() {

		Integer highest_emp_id = EmpDatabase.getAllEmpDet().stream().map(EmpDetails::getEid).reduce(Integer::max).get();

		System.out.println(highest_emp_id);

		Integer small_emp_id = EmpDatabase.getAllEmpDet().stream().map(EmpDetails::getEid)
				.reduce((a, b) -> a < b ? a : b).get();

		System.out.println(small_emp_id);

	}

	public static void UsingIterateMethod() {

		List<Integer> list = EmpDatabase.getAllEmpDet().stream().filter(emp -> emp.getEid() < 300)
				.map(EmpDetails::getEid).collect(Collectors.toList());

		Integer value = list.stream().reduce(100, (a, b) -> a + b).intValue();

		System.out.println(value);

		List<Integer> stream_of_int = Stream.iterate(1, x -> x * 2).limit(10).collect(Collectors.toList());

		System.out.println(stream_of_int);

	}

	public static void main(String[] args) {

		System.out.println(getHobbiesWithFlatMap());

		System.out.println("================================");

		System.out.println(getHobbiesWithFlatMapWithDistinct());

		System.out.println("==================================");

		usingReduceOperation();

		System.out.println("=======================");

		withFilter();

		System.out.println("=====================");
		usingFindFirstMethod();

		System.out.println("=======================");

		reduceMethodEmoDetClass();

		System.out.println("=========================");

		UsingIterateMethod();

	}

}
