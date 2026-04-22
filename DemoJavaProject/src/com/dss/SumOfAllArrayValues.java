package com.dss;

public class SumOfAllArrayValues {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int sum = 0;

		for (int v1 : arr) {
			sum = sum + v1;
		}

		System.out.println(sum);
	}

}
