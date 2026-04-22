package com.dss;

import java.util.HashSet;

public class Demo6 {

	public static void main(String[] args) {

		String str = "hello";

		str.concat("kumar");

		System.out.println(str);

		int arr[] = { 0, 1, 0, 0, 1, 1 };

		int temp = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int a1 : arr) {
			System.out.println(a1);
		}

		System.out.println("====================");
		
		

	}

}
