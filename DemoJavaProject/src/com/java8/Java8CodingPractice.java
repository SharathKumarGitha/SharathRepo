package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8CodingPractice {

	public static void main(String[] args) {

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);

		List<String> str_list = myList.stream().map(String::valueOf).

				filter(str -> str.startsWith("1")).

				collect(Collectors.toList());

		System.out.println(str_list);

		List<Integer> list_of_integers = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15, 49);

		List<Integer> list_with_distinct = list_of_integers.stream().distinct().collect(Collectors.toList());

		System.out.println(list_with_distinct);

		String input = "Java articles are Awesome";

		List<Character> list_with_char = new ArrayList();

		for (char c1 : input.toCharArray()) {
			list_with_char.add(c1);
		}

		System.out.println(list_with_char);

		Character result = list_with_char.stream()
				.collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1L).map(m1 -> m1.getKey()).findFirst().get();

		System.out.println("result is ......" + result);

	}

}
