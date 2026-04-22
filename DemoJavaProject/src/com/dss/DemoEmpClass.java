package com.dss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DemoEmpClass {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();

		names.add("sharath");

		names.add("sam");

		names.add("shankar");

		List<String> list2 = new CopyOnWriteArrayList<>(names);

		Iterator<String> iterator = list2.iterator();

		while (iterator.hasNext()) {
			String value = iterator.next();

			if (value.equals("sharath")) {
				names.add("manoj");
			}
		}

		System.out.println(list2);
	}

}
