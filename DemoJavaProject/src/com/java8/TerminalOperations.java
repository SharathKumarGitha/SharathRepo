package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TerminalOperations {

	public static void count() {

		long count = EmpDatabase.getAllEmpDet().stream().filter(emp -> emp.getEname().startsWith("s"))
				.filter(emp -> emp.getSalary() > 20000).count();

		System.out.println(count);

	}

	public static void usingGroupingBy() {
		Map<String, List<EmpDetails>> map = EmpDatabase.getAllEmpDet().stream()
				.collect(Collectors.groupingBy(emp -> emp.getGender()));

		System.out.println("map with gender....." + map);

		System.out.println("============================");

		Map<String, List<EmpDetails>> map_with_salary = EmpDatabase.getAllEmpDet().stream().collect(
				Collectors.groupingBy(emp -> emp.getSalary() > 25000 ? "outstanding salary" : "average salary"));

		System.out.println("map with salary......." + map_with_salary);

		System.out.println("========================");

		Map<String, Integer> map_variable = EmpDatabase.getAllEmpDet().stream()
				.collect(Collectors.groupingBy(EmpDetails::getGender, Collectors.summingInt(EmpDetails::getSalary)));

		System.out.println("summing of salary with gender" + map_variable);

		System.out.println("===============================");

		Map<String, List<EmpDetails>> map_variable2 = EmpDatabase.getAllEmpDet().stream()
				.collect(Collectors.groupingBy(EmpDetails::getGender, Collectors.toList()));

		System.out.println("gender with emp details..... " + map_variable2);

	}

	public static void joiningByExample() {

		String str = EmpDatabase.getAllEmpDet().stream().map(EmpDetails::getEname).collect(Collectors.joining("-"));

		System.out.println(str);

	}

	public static void minByMaxByExample() {
		EmpDetails highest_salary_empObj = EmpDatabase.getAllEmpDet().stream()
				.collect(Collectors.maxBy(Comparator.comparing(EmpDetails::getSalary))).get();

		System.out.println("highest salary object" + highest_salary_empObj);

		EmpDetails min_salary_empObj = EmpDatabase.getAllEmpDet().stream()
				.collect(Collectors.minBy(Comparator.comparing(EmpDetails::getSalary))).get();

		System.out.println("min salary object" + min_salary_empObj);
	}

	public static void partitionByExample() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

		System.out.println(partitioned);

		System.out.println("===============================");

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		Map<Boolean, List<EmpDetails>> map_with_emp = list.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getEname().startsWith("s"), Collectors.toList()));

		System.out.println("partioning by" + map_with_emp);

	}

	public static void main(String[] args) {

		count();

		System.out.println("===================");

		usingGroupingBy();

		System.out.println("=======================");

		joiningByExample();

		System.out.println("=======================");

		minByMaxByExample();

		System.out.println("========================================");

		partitionByExample();

	}

}
