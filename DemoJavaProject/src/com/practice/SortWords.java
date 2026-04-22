package com.practice;

public class SortWords {

	public static void main(String[] args) {

		String input = "banana apple mango";

		String arr[] = input.split(" ");

		for (int i = 0; i < arr.length; i++) {
			String temp;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (String a1 : arr) {
			System.out.println(a1);
		}
	}

}
