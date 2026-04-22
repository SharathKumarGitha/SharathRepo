package com.practice;

public class BubbleSortAlgorithm {

	public static void main(String[] args) {

		int arr[] = { 39, 41, 52, 9, 6, 3, 2, 1 };

		int temp = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int a1 : arr) {
			System.out.println(a1);
		}

	}

}
