package com.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyPracticeAfterLongTime {

	static Consumer<String> c1 = str -> System.out.println(str.toUpperCase());

	static Consumer<EmpDetails> c2 = emp -> System.out.println(emp);

	static Consumer<EmpDetails> c3 = emp -> System.out.println(emp.getEname().toUpperCase());

	static Consumer<EmpDetails> c4 = emp -> System.out.println(emp.getHobbies());

	static BiConsumer<Integer, String> bc1 = (b1, b2) -> System.out
			.println("my eid is " + b1 + " and my name is....." + b2);

	static Function<String, String> f1 = str -> str.toUpperCase();

	static Function<List<EmpDetails>, Map<String, Integer>> f5 = emp -> {

		Map<String, Integer> hm = new HashMap();

		emp.forEach(e -> {

			if (e.getEname().startsWith("s")) {
				hm.put(e.getEname(), e.getEid());
			}

		});

		return hm;
	};

	static Predicate<String> p1 = str -> str.startsWith("s");

	static Predicate<EmpDetails> p2 = emp -> emp.getEname().startsWith("s");

	static Predicate<EmpDetails> p3 = emp -> emp.getSalary() > 25000;

	static Predicate<String> p4 = str -> str.startsWith("s");

	static Predicate<String> p5 = str -> str.contains("sh");

	public static void getHigeshtSalaryEmpDet() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		EmpDetails highestPaid_using_reduce = list.stream()
				.reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
				.orElseThrow(() -> new RuntimeException("No employees found"));

		EmpDetails highestPaid_using_max = list.stream().max(Comparator.comparing(EmpDetails::getSalary))
				.orElseThrow(() -> new RuntimeException("No employees found"));

		System.out.println("hihest salary person......" + highestPaid_using_reduce);

		System.out.println("highest slalary person...." + highestPaid_using_max);

	}

	public static void printHobbies() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		List<String> hobbies = list.stream().map(EmpDetails::getHobbies).flatMap(Collection::stream)
				.collect(Collectors.toList());

		System.out.println(hobbies);

	}

	public static void usingReduceMethod() {

		List<Integer> list = EmpDatabase.getAllEmpDet().stream().map(EmpDetails::getEid).collect(Collectors.toList());

		System.out.println("complte list of ids ......" + list);

		Integer highest_id = list.stream().reduce((a, b) -> a > b ? a : b).get();

		System.out.println("highest id is " + highest_id);

		Integer min_id = list.stream().reduce(Integer::min).get();

		System.out.println("min id is " + min_id);

		Integer sum_of_ids = list.stream().reduce(Integer::sum).get();

		System.out.println("sum of ids...." + sum_of_ids);
	}

	public static void impMethods() {

		List<EmpDetails> sort_asc_with_enames = EmpDatabase.getAllEmpDet().stream()
				.sorted(Comparator.comparing(EmpDetails::getEname)).collect(Collectors.toList());

		System.out.println("sorting_with_names  " + sort_asc_with_enames);

		List<EmpDetails> with_sorting_of_two = EmpDatabase.getAllEmpDet().stream()
				.sorted(Comparator.comparing(EmpDetails::getEname).thenComparing(EmpDetails::getSalary))
				.collect(Collectors.toList());

		System.out.println("sorting with two conditions..." + with_sorting_of_two);

		List<EmpDetails> details2 = EmpDatabase.getAllEmpDet().stream().filter(emp -> emp.getEname().startsWith("s"))
				.skip(1).distinct().collect(Collectors.toList());

		System.out.println("using skip method" + details2);

		List<Integer> stream_of_int = Stream.iterate(1, x -> x * 2).limit(10).collect(Collectors.toList());

		System.out.println(stream_of_int);

	}

	public static void printEmpDetails() {
		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c2);
	}

	public static void printNames() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c3);

	}

	public static void printNamesAndIdWithCondition() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(emp -> {

			if (emp.getEname().startsWith("s")) {
				bc1.accept(emp.getEid(), emp.getEname());
			}
		});
	}

	public static void printNamesAndHobbies() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		Map<String, List<String>> hm = new HashMap<>();

		list.forEach(emp -> {

			if (emp.getEname().startsWith("s")) {

				hm.put(emp.getEname(), emp.getHobbies());
			}
		});

		System.out.println(hm);

	}

	public static void printAndThenOperation() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c3.andThen(c4));

	}

	public static void printUsingPredicateCondtion() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		List<EmpDetails> list_with_emp = list.stream().filter(p2.and(p3)).collect(Collectors.toList());

		System.out.println(list_with_emp);

	}

	public static void printPredicateWithConditionWithString() {

		List<String> names = Arrays.asList("sharath", "aruna", "shyam", "sharanya rao", "shankar");

		List<String> list_With_sh = names.stream().filter(p4.and(p5)).collect(Collectors.toList());

		System.out.println(list_With_sh);

	}

	public static void usingGroupingBy() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		Map<String, List<EmpDetails>> map = list.stream().collect(Collectors.groupingBy(EmpDetails::getGender));

		System.out.println("map with gender......" + map);

		Map<String, List<EmpDetails>> map2 =

				list.stream().collect(Collectors.groupingBy(emp -> emp.getSalary() > 25000 ? "good" : "average"));

		System.out.println("map with salary " + map2);

		Map<String, Integer> map3 =

				list.stream().collect(
						Collectors.groupingBy(EmpDetails::getGender, Collectors.summingInt(EmpDetails::getEid)));

		System.out.println("summing int " + map3);

		EmpDetails emp_highest_id = list.stream().collect(Collectors.maxBy(Comparator.comparing(EmpDetails::getEid)))
				.get();

		System.out.println(emp_highest_id);

		Map<Boolean, List<EmpDetails>> map_with_emp = list.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getEname().startsWith("s")));

		System.out.println("map with name start with s" + map_with_emp);

	}

	public static void main(String[] args) {

		c1.accept("sharath");

		System.out.println("===================================");

		printEmpDetails();

		System.out.println("============================");

		printNames();

		System.out.println("================================");

		printNamesAndIdWithCondition();

		System.out.println("=============================");

		printNamesAndHobbies();

		System.out.println("==============================");

		printAndThenOperation();

		System.out.println("===============================");

		System.out.println(f1.apply("sharath kumar"));

		System.out.println("==============================");

		System.out.println(f5.apply(EmpDatabase.getAllEmpDet()));

		System.out.println("====================================");

		System.out.println(p1.test("sharath"));

		System.out.println("===========================================");

		printUsingPredicateCondtion();

		System.out.println("===============================");

		printPredicateWithConditionWithString();

		System.out.println("=========================");

		getHigeshtSalaryEmpDet();

		System.out.println("=================================");

		printHobbies();

		System.out.println("==========================================");

		usingReduceMethod();

		System.out.println("===============================");

		impMethods();

		System.out.println("====================================");

		usingGroupingBy();

	}

}
