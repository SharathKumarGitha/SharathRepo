package com.dss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PraticalsPuprpose {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("sharath", "shashi", "samantha", "mahesh");

		System.out.println(list);
//
//		if (list.contains("sharath")) {
//			System.out.println("yes sharath is there");
//		} else {
//			System.out.println("sharath is not there");
//		}
//
//		// Object[] obj_array = list.toArray();
//
//		String[] srr = new String[list.size()];
//
//		list.toArray(srr);
//
//		for (String s1 : srr) {
//			System.out.println(s1);
//		}
//
//		

		ArrayList<String> list2 = new ArrayList<String>(list);

		list2.add(1, "mahesh babu");

		System.out.println(list2);

	}

}
