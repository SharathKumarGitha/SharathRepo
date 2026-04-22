package com.dss;

import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {

		System.out.println("this is line 1");

		System.out.println("this is line 2");

		try {
			System.out.println(10 / 0);

			System.out.println("this is sharath");
		} catch (ArithmeticException e) {

			System.out.println("please dont use 0");

			e.printStackTrace();
		}

		try {
			System.out.println("this is line 3");

			System.out.println("this is line 4");

			System.out.println(10 / 2);

			System.out.println("ratan".charAt(10));
		}

		catch (ArithmeticException e) {

			System.out.println("this is second catch block....");

			System.out.println("please dont use 0 in this case also...");
		}

		catch (StringIndexOutOfBoundsException e) {

			System.out.println("please enter valid range...");

			e.printStackTrace();
		}

		System.out.println("rest of the code");

		System.out.println("==========================");

		Scanner s = new Scanner(System.in);
		System.out.println("enter a number");
		int n = s.nextInt();
		try {
			System.out.println(10 / n);
			System.out.println("ratan".charAt(13));
		} catch (ArithmeticException | ClassCastException a) {
			a.printStackTrace();
			System.out.println("exception info=" + a);
		} catch (NumberFormatException | NullPointerException | StringIndexOutOfBoundsException a) {
			a.printStackTrace();
			System.out.println("exception info=" + a);
		}
		System.out.println("Rest of the application");

	}

}
