package com.practice;

public class SelectionSortExample {

	public static void main(String[] args) {

		int arr[] = { 39, 40, 30, 1, 2, 4 };

		int temp;

		for (int i = 0; i < arr.length; i++) {
			int min = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;

		}

		for (int a1 : arr) {
			System.out.println(a1);
		}
	}

}
