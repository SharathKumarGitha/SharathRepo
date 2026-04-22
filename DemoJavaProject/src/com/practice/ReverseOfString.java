package com.practice;

public class ReverseOfString {

	public static void main(String[] args) {

		String str = "hello this is sharath";

		char temp;

		char ch[] = str.toCharArray();

		for (int i = 0, j = ch.length - 1; i < j; i++, j--) {

			temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;

		}

		System.out.println(new String(ch).replaceAll(" ", ""));
	}

}
