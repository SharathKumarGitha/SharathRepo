package com.dss;

import java.util.HashSet;

public class StringArrayReverse {

	public static void main(String[] args) {

		String arr[] = { "hi", "how ru", "my name is sharath" };

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i] + " ");
		}

		int arr1[] = { 1, 2, 3, 4, 5, 6 };

		int arr2[] = { 1, 2, 3, 9, 10, 11 };

		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					hs.add(arr1[i]);
				}
			}
		}

		System.out.println(hs);
	}

}
