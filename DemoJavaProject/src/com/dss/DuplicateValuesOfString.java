package com.dss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class DuplicateValuesOfString {
	
	

	public static void main(String[] args) {

		String arr[] = { "deepak", "aruna", "johny", "cena", "lucky", "cena", "lucky", "deepak", "johny" };

		String temp = " ";

		for (int i = 0; i < arr.length; i++) {
			int flag = 0;
			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					flag = 1;
				}
			}

			if (flag == 0) {
				break;
			}
		}

		System.out.println("after sorting.....");

		for (String str : arr) {
			System.out.println(str);
		}

		duplicate(arr);
		
	

	}

	static void duplicate(String[] array) {

		int i, j, frequency;

		int min = 0;

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
