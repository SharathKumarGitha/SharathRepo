package com.dss;

import java.util.Arrays;

public class KthSmallestAndLargetElementInJava {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };

		Arrays.sort(arr);

		int kth_element = 3;

		int smallest = 0;

		int highest = 0;

		highest = arr[arr.length - kth_element];

		smallest = arr[0 + (kth_element - 1)];

		System.out.println(highest + " " + smallest);
		
		

	}

}
