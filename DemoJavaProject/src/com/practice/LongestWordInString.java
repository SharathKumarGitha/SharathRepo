package com.practice;

public class LongestWordInString {

	public static void main(String[] args) {

		String statement = "java is powerful lang";

		String str[] = statement.split(" ");

		int highest = str[0].length();

		for (int i = 0; i < str.length; i++) {
			if (str[i].length() > highest) {
				// highest=str[i].length();

				System.out.println("highest lengh in string is ....." + str[i]);
			}
		}

	}

}
