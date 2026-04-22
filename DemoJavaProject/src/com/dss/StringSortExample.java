package com.dss;

import java.util.Arrays;
import java.util.List;

public class StringSortExample {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("sharath", "anu");

		list.stream().sorted().forEach(l1 -> System.out.println(l1));

	}

}
