package com.dss;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNameCount {

	public static void main(String[] args) {

		String arr[] = { "sharath", "shashi", "sai", "arun", "shashi", "sharath" ,"sharath","srinivas"};

		Map<String, Integer> hm = new HashMap<String, Integer>();

		int count = 1;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (hm.containsKey(arr[i])) {

				hm.put(arr[i], hm.get(arr[i])+1);
			} else {
				hm.put(arr[i], count);
			}
		}

		System.out.println(hm);

	}

}
