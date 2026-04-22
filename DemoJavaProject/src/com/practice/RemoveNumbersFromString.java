package com.practice;

public class RemoveNumbersFromString {

	public static void main(String[] args) {

		String str = "hello123Sharath";

		String new_string = str.replaceAll("[0-9]", "");

		System.out.println(new_string);

		System.out.println("======================");

		StringBuilder builder = new StringBuilder();


		String new_one = "hello123Sharath";

		char ch[] = new_one.toCharArray();

		for (int i = 0; i < ch.length; i++) {
		    if (!(ch[i] >= '0' && ch[i] <= '9')) {
		        builder.append(ch[i]);
		    }
		}

		System.out.println(builder);
	}

}
