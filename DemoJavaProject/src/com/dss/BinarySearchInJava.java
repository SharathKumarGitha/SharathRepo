package com.dss;

public class BinarySearchInJava {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 5, 6, 7, 8, 9, 10, 11 };

		int search_element = 7;

		int lower = 0;

		int high = arr.length - 1;

		int middele = (high + lower) / 2;

		while (lower <= high) {
			if (arr[middele] == search_element) {
				System.out.println("eleement found this location  " + middele + " ");

				break;
			}

			if (arr[middele] < search_element) {
				lower = middele + 1;
			}

			else {
				high = middele - 1;
			}

			middele = (high + lower) / 2;
		}

		if (lower > high) {
			System.out.println("element not found....");
		}
	}

}
