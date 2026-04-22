package com.dss;

public class SmallestSubArray {

	public static void main(String[] args) {

		int arr[] = { 7, 2, 1, 1, 6, 5 };

		int k = 11;

		int min_length = 0;

		int i, j;

		for (i = 0; i < arr.length; i++) {
			int sum = 0;

			for (j = i; j < arr.length; j++) {
				sum = sum + arr[j];

				if (sum >= k) {
					min_length = (j - i) + 1;
					break;
				}
			}
		}
		System.out.println(min_length);
	}
}
