package com.dss;

import java.util.Arrays;

public class LongestSubSequenceInTheString {

	public static void main(String[] args) {

		String str = "AABEBCDD";

		String value = " ";

		char ch[] = str.toCharArray();

		Arrays.sort(ch);

		int i, j;

		for (i = 0; i < ch.length; i++) {
			int frequency = 1;
			for (j = i + 1; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					frequency++;
				} else {
					break;
				}
			}

			i = j - 1;

			if (frequency>1) {
				value = value + ch[i];
			}
		}

		System.out.println(value);
	}

}
