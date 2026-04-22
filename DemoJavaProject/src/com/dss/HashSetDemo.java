package com.dss;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();

		set.add("sharath");

		set.add("shashi");

		boolean value = set.add("sharath");

		set.add("swamy");

		set.add("rahul");

		set.add("kane");

		System.out.println(value);
		System.out.println(set);

		System.out.println("==========================================");

		String arr[] = new String[set.size()];

		set.toArray(arr);

		for (String str : arr) {
			System.out.println(str);
		}

		System.out.println("=======================");

		HashSet<String> h_set = new HashSet<String>();
		// use add() method to add values in the hash set
		h_set.add("Red");
		h_set.add("Green");
		h_set.add("Black");
		h_set.add("White");
		h_set.add("Pink");
		h_set.add("Yellow");
		System.out.println("Original Hash Set: " + h_set);
		HashSet<String> new_h_set = new HashSet<String>();
		new_h_set = (HashSet) h_set.clone();
		System.out.println("Cloned Hash Set: " + new_h_set);

	}

}
