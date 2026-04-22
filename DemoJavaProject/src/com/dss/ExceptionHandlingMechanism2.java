package com.dss;

import java.util.Scanner;

public class ExceptionHandlingMechanism2 {

	public static void main(String[] args) {

		int arr[] = new int[3];

		Scanner input = new Scanner(System.in);

		System.out.println("please enter range");

		int n = input.nextInt();

		try {

			System.out.println("entering into try block......");

			System.out.println(10 / n);

			for (int i = 0; i < arr.length; i++) {
				System.out.println("please enter " + i + " value");

				arr[i] = input.nextInt();
			}

			System.out.println(arr[7]);

		}

		catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {

			System.out.println("please write code properly....");
		}

		System.out.println("rest of the code....");
	}

}
