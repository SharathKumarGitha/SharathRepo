package com.practice;

public class ReverseofWordsProgram {

	public static void main(String[] args) {

		String statement = "hi this is sharath from hyderabad";

		String str[] = statement.split(" ");

		for (int i = 0; i < str.length; i++) {
			str[i] = new String(reverse(str[i].toCharArray()));
		}

		for (String arr : str) {
			System.out.println(arr);
		}

		System.out.println("=====================");

		String statement2 = "hi this is sharath from hyderabad";

		String arr[] = statement2.split(" ");
		
		arr=reverseWords(arr);
		
		for(String a2:arr)
		{
			System.out.println(a2);
		}

		

	}

	private static char[] reverse(char ch[]) {
		char temp;
		for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
			temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}

		return ch;
	}

	private static String[] reverseWords(String str[]) {

		String temp;
		for (int i = 0, j = str.length - 1; i < j; i++, j--) {
			temp = str[i];
			str[i] = str[j];
			str[j] = temp;
		}

		return str;

	}

}
