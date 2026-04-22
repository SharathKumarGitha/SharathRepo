
package com.dss;

public class RemoveDuplicateElementsInArray {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 2, 3, 4, 4, 5, 5, 6 };

		int arr2[] = new int[arr.length];

		int j = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr2[j] = arr[i];
				j++;
			}
		}

		arr2[j] = arr[arr.length - 1];

		for (int i = 0; i <j+1; i++) {
			System.out.println(arr2[i]);
		}
	}

}
