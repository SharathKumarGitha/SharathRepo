package com.dss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<>();

		names.add("sharath");

		names.add("suguna");

		names.add("odelu");

		names.add("shashi");

		System.out.println(names);

		if (names.isEmpty()) {
			System.out.println("list is zero");
		} else {
			System.out.println("list containing elements.....");
		}

		Iterator<String> itr = names.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}

		if (names.contains("shashi")) {
			System.out.println("remove shashi...." + names.remove("shashi"));
		} else {
			System.out.println("no shashi there ,please check.....");
		}

		System.out.println("==========================");

		String[] arr = new String[names.size()];

		arr = names.toArray(arr);

		for (String str : arr) {
			System.out.println(str);
		}

		System.out.println("==============================");

		boolean value = names.remove("odelu");

		System.out.println("yes shashi is removed...." + value);

		System.out.println(names.size() + " " + names);

		for (String value2 : names) {
			System.out.println(value2);
		}

		System.out.println("===========================");

		ArrayList<String> names2 = new ArrayList<>();

		names2.add("suguna");

		names.add("manoj");

		if (names.containsAll(names2)) {
			System.out.println("all values is there,yes it is true");
		} else {
			System.out.println("not containig values....");
		}

		System.out.println("===========================");

		String present_value = names2.set(0, "sharath");

		System.out.println(present_value);

		System.out.println(names2);

		int index = names2.indexOf("sharath");

		System.out.println(index);

		System.out.println("================================");

		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);

		// System.out.println(numbers2.retainAll(numbers3));

		System.out.println(numbers2);

		System.out.println("==============================");

		List<Integer> sublist = numbers1.subList(2, 6);

		System.out.println(sublist);

		System.out.println("=======================================");

		ArrayList<Integer> list1 = new ArrayList<Integer>();

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		System.out.println("list1: " + list1);

		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list2.add(2);
		list2.add(4);
		list2.add(6);
		System.out.println("list2: " + list2);

		System.out.println("list1.retainAll(list2)");
		list1.retainAll(list2);
		System.out.println("list1: " + list1);

		Integer first_value = list1.get(0);

		System.out.println(first_value);

		System.out.println("==============================");

		// create an ArrayList
		ArrayList<String> languages = new ArrayList<>();

		// add elements to the ArrayList
		languages.add("java");
		languages.add("javascript");
		languages.add("swift");
		languages.add("python");
		System.out.println("ArrayList: " + languages);

		// replace all elements to uppercase
		languages.replaceAll(l -> l.toUpperCase());
		System.out.println("Updated ArrayList: " + languages);

		languages.sort((i1, i2) -> i1.compareTo(i2));

		System.out.println("sorted arraylist......" + languages);

		System.out.println("========================");

		Set<String> set = new HashSet<String>();

		set.add("sharath");

		set.add("shashi");

		set.add("mahesh");

		set.add("john cena");

		set.add("cody rhodes");

		// System.out.println(set);

		ArrayList<String> al = new ArrayList<>(set);

		System.out.println(al);

		System.out.println("==================================");

		int[] arr1 = { 1, 2, 3, 4, 5 };

		int[] arr2 = Arrays.copyOf(arr1, 10);

		System.out.println(arr2.length);

		for (int a2 : arr2) {
			System.out.println(a2);
		}

	}
}
