package com.dss;

public class PerfectNumber {

	public static void main(String[] args) {

		 //28
		
		int value =6; 

		int sum = 0;

		for (int i = 1; i < value; i++) {
			if (value % i == 0) {
				sum = sum + i;
			}
		}

		if (sum == value) {
			System.out.println("this is perfect number");
		} else {
			System.out.println("this is not perfect number....");
		}
	}

}
