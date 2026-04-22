package com.dss;

import java.util.Scanner;

public class ExceptionHandlingExample {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("please enter divison value");

		int value = input.nextInt();

		try {
			System.out.println("first statement in try block....");

			System.out.println(10 / value);

//			String str = null;
//
//			System.out.println(str.length());
		}

		catch (ArithmeticException e) {

			System.out.println("divison value should not be 0");

			e.printStackTrace();

		}

//		try {
//			int a = 10 / 0;
//		}
//
//		catch (ArithmeticException e) {
//			
//			System.out.println("going to arithmetic block...");
//
//			int a = 10 / 0;
//
//			System.out.println(a);
//		}

//		catch (NullPointerException e) {
//
//			System.out.println("if we are taking null we cannot find the length");
//
//			e.printStackTrace();
//		}

		try {
			System.out.println(10 / 0);
		}

		catch (ArithmeticException e2) {

			//System.exit(0);

			e2.printStackTrace();

		}

		finally {

			System.out.println("this is final block....");
		}

		System.out.println("this is normal code.....");
		
		
		System.out.println("==============================");
		
		
		
		

	}

}
