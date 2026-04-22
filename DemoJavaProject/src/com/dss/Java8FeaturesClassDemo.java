package com.dss;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.print.attribute.standard.JobOriginatingUserName;

@FunctionalInterface
interface first {
	public void m1();

	default void show() {
		System.out.println("this is default method");
	}

}

class Emp_Data {
	private Integer eid;

	private String ename;

	public Emp_Data(Integer eid, String ename) {
		this.eid = eid;
		this.ename = ename;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Emp_Data [eid=" + eid + ", ename=" + ename + "]";
	}

	public boolean enameCheck() {
		return ename.startsWith("s");
	}
}

class Emp_Data2 {
	private Integer eid;

	private List<String> names;

	public Emp_Data2(Integer eid, List<String> names) {
		this.eid = eid;
		this.names = names;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	@Override
	public String toString() {
		return "Emp_Data2 [eid=" + eid + ", names=" + names + "]";
	}

}

@FunctionalInterface
interface Second {
	public String secondMethod(String username, String password);
}

public class Java8FeaturesClassDemo {

	public static void main(String[] args) {

		first f1 = () -> {
			System.out.println("this is m1 method");
			System.out.println("second statement");

			System.out.println("this is third statement");
		};

		f1.m1();

		f1.show();

		System.out.println("===================");

		Second sec = (username, password) -> {
			return username.equals("sharath") && password.equals("sharath") ? "login success" : "login fail";
		};

		String status = sec.secondMethod("sharath", "sharath");

		System.out.println(status);

		System.out.println("=================");

		List<String> names = Arrays.asList("sharath", "shashi", "anu", "alekya", "anusha");

		names.forEach(name -> System.out.println(name));

		System.out.println("====================");

		names.forEach(System.out::println);

		System.out.println("====================================");

		Emp_Data data1 = new Emp_Data(1, "shashi");

		Emp_Data data2 = new Emp_Data(3, "sam");

		Emp_Data data3 = new Emp_Data(5, "anu");

		Emp_Data data4 = new Emp_Data(6, "arun");

		Emp_Data data5 = new Emp_Data(7, "alekya");

		Emp_Data data6 = new Emp_Data(10, "samantha");

		List<Emp_Data> list = Arrays.asList(data1, data2, data3, data4, data5, data6);

		list.forEach(System.out::println);

		System.out.println("======================");

		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "shashi");

		map.put(2, "sam");

		map.put(3, "ram");

		map.put(4, "rahsmika");

		map.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println("========================");

		list.stream().filter(emp -> emp.getEid() % 2 == 0).forEach(emp -> System.out.println(emp));

		System.out.println("===============");

		list.stream().filter(Emp_Data::enameCheck).forEach(emp -> System.out.println(emp));

		System.out.println("==========================");

		list.stream().filter(Emp_Data::enameCheck).

				map(emp -> {
					emp.setEid(emp.getEid() + 2);
					return emp;
				}).forEach(emp -> System.out.println(emp));

		System.out.println("===================================");

		List<Integer> list_of_values = Arrays.asList(1, 2, 4, 4, 5, 6, 7, 10);

		Integer sum = list_of_values.stream().reduce((i1, i2) -> i1 + i2).get();

		System.out.println(sum);

		System.out.println("===================================");

		List<String> list_of_names_with_String = list.stream().map(Emp_Data::getEname).collect(Collectors.toList());

		System.out.println(list_of_names_with_String);

		String addedvalue = list_of_names_with_String.stream().reduce((i1, i2) -> i1 + i2).get();

		System.out.println(addedvalue);

		System.out.println("==========================================");

		String total_value = list_of_names_with_String.stream()
				.filter(name -> name.startsWith("a") && name.length() > 2).

				map(name -> name + "reddy").reduce((i1, i2) -> i1 + i2).get();

		System.out.println(total_value);

		System.out.println("=================================");

		List<String> city_names = Arrays.asList("karimnagar", "ap", "siricilla", "peddapalli", "hyd");

		Collections.sort(city_names, Comparator.reverseOrder());

		city_names.sort(String::compareTo);

		System.out.println(city_names);

		city_names.sort((i1, i2) -> i1.compareTo(i2));

		System.out.println(city_names);

		System.out.println("=====================================");

		List<Integer> values = Arrays.asList(5, 4, 3, 7, 28, 25, 11, 12, 14, 13, 15);

		values.stream().filter(i -> i < 10).map(value -> value * 10).sorted(Comparator.reverseOrder())
				.forEach(System.out::println);

		System.out.println("===================================");

		Comparator<Emp_Data> emp_data_with_comp = Comparator.comparing(Emp_Data::getEname);

		list.sort(emp_data_with_comp);

		System.out.println(list + " emp_data_with_comp");

		System.out.println("=========================");

		list.sort(Comparator.comparing(Emp_Data::getEid));

		System.out.println(list);

		System.out.println("==========================");

		list.sort((i1, i2) -> i1.getEname().compareTo(i2.getEname()));

		System.out.println(list);

		System.out.println("===================================");

		List<String> new_names = Arrays.asList("sharath", "shashi", "sa", "sp");

		long count = new_names.stream().filter(String::isEmpty).count();

		System.out.println(count);

		System.out.println("========================================");

		long count2 = new_names.stream().filter(name -> !name.isEmpty()).count();

		System.out.println(count2);

		String my_name = "sharath";

		long count3 = new_names.stream().filter(name -> !name.contentEquals("sharath")).count();

		System.out.println(count3);

		System.out.println("===========================");

		long count4 = new_names.stream().filter(String::isEmpty).count();

		Emp_Data2 e1 = new Emp_Data2(222, Arrays.asList("sharath", "sam", "kane", "sam"));

		Emp_Data2 e2 = new Emp_Data2(222, Arrays.asList("sharath", "sam", "kane", "sam"));

		List<Emp_Data2> list_emp2 = Arrays.asList(e1, e2);

		List<String> names_values = list_emp2.stream().map(Emp_Data2::getNames).flatMap(Collection::stream)
				.collect(Collectors.toList());

		System.out.println(names_values);

		System.out.println("=========================================");

		List<String> items = Arrays.asList("chicken", "mutton", "sweet", "chicken", "mutton", "sweet", "paneer");

		Map<String, Long> count_map = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(count_map);
		
		
		System.out.println("=====================");

		Map<String, Long> sorted_linked_map = new LinkedHashMap<>();

		count_map.entrySet().stream().

				sorted(Map.Entry.<String, Long>comparingByKey())
				.forEachOrdered(e -> sorted_linked_map.put(e.getKey(), e.getValue()));

		System.out.println(sorted_linked_map);

		
	}

}
