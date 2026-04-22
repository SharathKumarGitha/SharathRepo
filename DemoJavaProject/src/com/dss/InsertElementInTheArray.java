package com.dss;

public class InsertElementInTheArray {

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40, 50 };

		int position = 3;

		int insert_element = 100;

		for (int i = arr.length - 1; i > position - 1; i--) {
			arr[i] = arr[i - 1];
		}

		arr[position - 1] = insert_element;

		System.out.println("==============================");

		for (int a1 : arr) {
			System.out.println(a1);
		}
	}

}
