package com.dss;

public class MinimumAndMaxNumberInJava {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };

		int min = arr[0];

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		System.out.println("minimum value is..." + min);

		System.out.println("maximum value is..." + max);
	}

}
