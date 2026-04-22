package com.dss;

import java.util.Arrays;

public class Main {

	// main method
	public static void main(String[] args) {

		// Declare and initialize the array elements
		int[] array = { 2, 3, 5, 4, 3, 1, 3, 2, 1, 9, 2, 9, 9, 9, 2 };

		// sorting an array
		Arrays.sort(array);
		System.out.println("These elements are repeated along with its frequency-");

		// call a user defined method
		duplicate(array);
	}

	// user defined method
	static void duplicate(int[] array) {

		// declared the variables
		int i, j, frequency;

		int min = 0;

		// loop for logic implementation
//		for (i = 0; i < array.length; i++) {
//			frequency = 1;
//			for (j = i + 1; j < array.length; j++) {
//				if (array[j] == array[i]) {
//					frequency++;
//				} else {
//					break;
//				}
//			}
//			i = j - 1;
//			if (frequency > 1) {
//				// printing the output
//				System.out.println(array[i] + " --> " + frequency);
//			}
//		}

		for (i = 0; i < array.length; i++) {
			frequency = 1;

			for (j = i + 1; j < array.length; j++) {
				if (array[j] == array[i]) {
					frequency++;
				} else {
					break;
				}
			}

			i = j - 1;

			if (frequency > 1) {
				System.out.println(array[i] + "----->" + frequency);
			}

		
		}
	}

}