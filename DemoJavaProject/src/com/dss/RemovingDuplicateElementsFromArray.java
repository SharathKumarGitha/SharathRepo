package com.dss;

import java.util.ArrayList;
import java.util.List;

public class RemovingDuplicateElementsFromArray {

	public static void main(String[] args) {

		int arr[] = { 1,1, 2, 3, 4, 2, 3, 5, 6, 7,1, 5 ,9,10,9};

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (list.contains(arr[i])) {
				System.out.println("duplicate exists..." + arr[i]);
			} else {
				list.add(arr[i]);
			}
		}

		System.out.println("===================");

		String duplicate_elements = " ";

		for (int i = 0; i < arr.length-1; i++) {

			int counter = 1;
			for (int j =i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					counter = counter + 1;
				}
			}

			if (counter > 1) {
				duplicate_elements = duplicate_elements + arr[i] + " ";
				
			}
		}

		System.out.println(duplicate_elements);
		
		
		//System.out.println("=========================");
		
		
		
	}

}
