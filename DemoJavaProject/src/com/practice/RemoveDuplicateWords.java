package com.practice;

public class RemoveDuplicateWords {
	
	public static void main(String[] args) {
		
		String input = "java is java is randy ";

		String[] words = input.split(" ");

		for (int i = 0; i < words.length; i++) {
		    boolean isDuplicate = false;

		    for (int j = 0; j < i; j++) {
		        if (words[i].equals(words[j])) {
		            isDuplicate = true;
		            break;
		        }
		    }

		    if (!isDuplicate) {
		        System.out.print(words[i] + " ");
		    }
		}
	}

}
