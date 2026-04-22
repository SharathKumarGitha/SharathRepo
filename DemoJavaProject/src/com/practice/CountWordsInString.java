package com.practice;

public class CountWordsInString {

	public static void main(String[] args) {

		String sample = "hi this is sharath java is from  java karimnagar";

		String words[] = sample.split(" ");

		for (int i = 0; i < words.length; i++) {
			int frequency = 1;

			for (int j = i + 1; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					frequency++;
					words[j] = "0";
				}

			}

			if (frequency > 1 && !words[i].equals("0")) {
				System.out.println(words[i] + " " + frequency);
			}
		}

	}

}
