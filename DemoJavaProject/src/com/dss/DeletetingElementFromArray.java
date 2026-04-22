package com.dss;

public class DeletetingElementFromArray {

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40, 50, 60 };

		int delete_element = 30;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == delete_element) {
				for (int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j + 1];
				}
				//break;
			}
		}

		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println(arr[i]);
		}
	}

}
