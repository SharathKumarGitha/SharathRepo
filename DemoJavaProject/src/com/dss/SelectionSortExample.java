package com.dss;

public class SelectionSortExample {

	public static void main(String[] args) {

		int arr[] = { 10, 4, 5, 2, 1, 3, 6 };

		int temp = 0;

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
		
		
		for(int a2:arr)
		{
			System.out.println(a2);
		}

	}

}
