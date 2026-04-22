package com.dss;

public class Demo3 {

	public static void main(String[] args) {

		for (int i = 2; i <= 10; i = i + 2) {

			System.out.println("this is even  number..." + i);

		}

		System.out.println("========================================");

		for (int i = 1; i <= 10; i = i + 2) {
			System.out.println("odd nubers are ...." + i);
		}

		System.out.println("====================");

		for (int i = 1; i <= 10; i = i + 1) {
			System.out.println("square numbers  are ...." + i * i);
		}

		System.out.println("=========================================");

		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
		}

		System.out.println("sum of the elements is...." + sum);

		System.out.println("====================");

//		

		int rows = 5;

		for (int i = 1; i <= rows; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		System.out.println("======================");

		int arr[] = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int a1 : arr) {
			System.out.println(a1);
		}

		System.out.println("=======================");

		int values[] = { 5, 4, 3, 2, 1 };

		int temp = 0;

		for (int i = 0; i < values.length - 1; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] > values[j]) {
					temp = values[i];
					values[i] = values[j];
					values[j] = temp;
				}
			}

		}

		for (int m = 0; m < values.length; m++) {
			System.out.println(values[m]);
		}

		System.out.println("========================");
		
		
		

	}

}
