package com.dss;

public class EvenAndOddNumbersInArray {

	public static void main(String[] args) {

		int arr[] = { 59, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("even numbers are...");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			}
		}

		System.out.println("odd numbers are");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {

				System.out.println(arr[i]);
			}
		}
	}

}
