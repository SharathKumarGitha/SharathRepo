package com.practice;

public class VowesRemoval {

	public static void main(String[] args) {

		String str = "hi this is sharath from karimnagar";

		char ch[] = str.toCharArray();

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < ch.length; i++) {
			if (validate(ch[i])) {

				builder.append(ch[i]);

			}
		}

		System.out.println(builder.toString().replaceAll(" ", ""));

	}

	private static boolean validate(char ch) {

		if ("AEIOUaeiou".indexOf(ch) == -1) {
			return true;
		}

		return false;

	}

}
