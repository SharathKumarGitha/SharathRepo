package com.dss;

import java.util.HashSet;

public class LongestSequenceInArray {

	public static void main(String[] args) {

		int arr[] = { 3, 9, 1, 10, 4, 20, 2 };

		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			hs.add(arr[i]);
		}

		int max_length = 0;

		for (int i = 0; i < arr.length; i++) {

			int num = 0;
			if (!hs.contains(arr[i] - 1)) {
				num = arr[i];
			}

			while (hs.contains(num)) {
				num++;
			}

			if (max_length < num - arr[i]) {
				max_length = num - arr[i];
			}
		}

		System.out.println(max_length);

	}

}
