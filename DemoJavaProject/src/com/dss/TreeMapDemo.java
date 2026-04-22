package com.dss;

import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {

		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

		tm.put(5, "sharath");

		tm.put(4, "sunny");

		tm.put(2, "arjun");

		System.out.println(tm);
	}

}
