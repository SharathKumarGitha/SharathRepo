package com.dss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<Integer, String> hm = new HashMap<>();

		hm.put(1, "sharath");

		hm.put(2, "shashi");

		hm.put(3, "sampath");

		hm.put(4, "arjun");

		hm.put(3, "suguna");

		hm.put(null, "sharath");

		// System.out.println(hm);

		Set<Integer> key_set = hm.keySet();

		System.out.println(key_set);

		Integer[] arr = new Integer[key_set.size()];

		key_set.toArray(arr);

		for (int i = 0; i < arr.length; i++) {

			System.out.println(hm.get(arr[i]));
		}

		System.out.println("==============================");
		Set<Map.Entry<Integer, String>> entry = hm.entrySet();

		Iterator<Map.Entry<Integer, String>> itr = entry.iterator();

		while (itr.hasNext()) {

			Map.Entry<Integer, String> entry_map = itr.next();

			Integer keys = entry_map.getKey();

			String value = entry_map.getValue();

			System.out.println(" key is " + keys + "  and value is  " + value);

		}

	}
}
