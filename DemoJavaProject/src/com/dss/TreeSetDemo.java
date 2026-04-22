package com.dss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {

		TreeSet ts = new TreeSet();

		ts.add(2);

		ts.add(3);

		ts.add(1);

		ts.add(5);

		ts.add(4);

		System.out.println(ts);

		SortedSet set = ts.headSet(5);

		System.out.println(set);

		SortedSet tail_set = ts.tailSet(3);

		System.out.println(tail_set);

		System.out.println("================");

		List<String> list = Arrays.asList("sharath", "shashi", "sampath kumar", "randy orton");

		String longest_string = list.stream().max(Comparator.comparingInt(String::length)).get();

		System.out.println(longest_string.length());
		
		

	}

}
