package com.dss;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {

		int arr[] = { 30, 40, 50, 60, 10 };

		int temp = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int a1 : arr) {
			System.out.println(a1);
		}

		System.out.println("ending of first program........");

		String str[] = { "sharath", "anu", "xyz", "aruna", "raji" };

		String temp2 = null;

		for (int i = 0; i < str.length; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (str[j].compareTo(str[j + 1]) > 0) {
					temp2 = str[j];

					str[j] = str[j + 1];
					str[j + 1] = temp2;
				}
			}
		}

		for (String str2 : str) {
			System.out.println(str2);
		}

		System.out.println("ending of second program...............");

		String names[] = { "sharath", "sharath", "arjun", "sharath", "arjun", "alekya" };

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < names.length; i++) {
			if (map.containsKey(names[i])) {
				map.put(names[i], map.get(names[i]) + 1);
			} else {
				map.put(names[i], 1);
			}
		}

		System.out.println(map);

		System.out.println("ending of third program.............");

		int elements[] = { 10, 20, 30, 40, 50, 60 };

		int del_element = 30;

		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == del_element) {
				for (int j = i; j < elements.length - 1; j++) {
					elements[j] = elements[j + 1];
				}
			}
		}

		for (int i = 0; i < elements.length - 1; i++) {
			System.out.println(elements[i]);
		}

		System.out.println("ending of fourth program........");

		int elements2[] = { 10, 20, 30, 40, 50, 60 };

		int position = 3;

		for (int i = elements2.length - 1; i > position - 1; i--) {

			elements2[i] = elements2[i - 1];
		}

		elements2[position - 1] = 100;

		for (int values : elements2) {
			System.out.println(values);
		}

		System.out.println("ending of 5th program........");

		String names_array[] = { "sharath", "sharath", "arjun", "arjun", "aleya" };

		count(names_array);

		System.out.println("ending of 6th program.......");

		int new_elements[] = { 10, 20, 30, 40, 50 };

		int min = new_elements[0];

		int max = new_elements[0];

		for (int i = 0; i < new_elements.length; i++) {
			if (new_elements[i] < min) {
				min = new_elements[i];
			}
			if (new_elements[i] > max) {
				max = new_elements[i];
			}
		}

		System.out.println("max number is ....." + max);

		System.out.println("minimum number is...." + min);

		System.out.println("ending of 6th program.......");

		String name = "sharath";

		char ch[] = name.toCharArray();

		for (char ch2 : getCharArray(ch)) {
			System.out.println(ch2);
		}

		System.out.println("ending of 7th program.....");

		String vowels = "hi this is sharath";

		char vow[] = vowels.toCharArray();

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < vow.length; i++) {
			if (validate(vow[i])) {
				builder.append(vow[i]);
			}
		}

		System.out.println(builder.toString().replaceAll(" ", ""));

		System.out.println("ending of 8th program......");

		String statement = "hi this is sharath from hyderabad";

		String statement_arr[] = statement.split(" ");

		for (int i = 0; i < statement_arr.length; i++) {
			statement_arr[i] = new String(getCharArray(statement_arr[i].toCharArray()));
		}

		for (String values : statement_arr) {
			System.out.println(values);
		}

		System.out.println("ending of 9th program.....");

		String statement2 = "hi this is sharath from java";

		String statement2_arr[] = statement2.split(" ");

		String new_string[] = getStringArray(statement2_arr);

		for (String demo : new_string) {
			System.out.println(demo);
		}

		String with_num = "ABC123XYZ";

		char num_char_arr[] = with_num.toCharArray();

		StringBuilder builder_with_no_digit = new StringBuilder();

		for (int i = 0; i < num_char_arr.length; i++) {
			if (!(num_char_arr[i] > '0' && num_char_arr[i] < '9')) {
				builder_with_no_digit.append(num_char_arr[i]);
			}
		}

		System.out.println(builder_with_no_digit.toString());

	}

	private static void count(String arr[]) {

		int j;

		for (int i = 0; i < arr.length; i++) {
			int frequency = 1;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					frequency++;
				} else {
					break;
				}
			}

			i = j - 1;

			System.out.println(arr[i] + "........" + frequency);
		}
	}

	private static char[] getCharArray(char ch[]) {

		for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}

		return ch;
	}

	private static String[] getStringArray(String ch[]) {

		for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
			String temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}

		return ch;
	}

	private static boolean validate(char ch) {
		if ("AEIOUaeiou".indexOf(ch) == -1) {
			return true;
		}
		return false;
	}

}
