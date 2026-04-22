package com.dss;

import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionScenario {

	public static void main(String[] args) {

		System.out.println("this is static method methods calling....");

		// m1();

		Scanner s = null;

		try {
			s = new Scanner(System.in);
			System.out.println("enter id");

			int id = s.nextInt();

			System.out.println("id value is.." + id);

		}

		catch (InputMismatchException e) {

			e.printStackTrace();

			System.out.println("entered wrong input....");
		}

		finally {

			s.close();

			System.out.println("finally block is closed....");
		}

//		System.out.println("enter another id");
//
//		int id2 = s.nextInt();
//
//		System.out.println(id2);

		try {
			Scanner input = new Scanner(System.in);

			System.out.println("enter id");

			int id3 = input.nextInt();

			System.out.println(id3);

			FileInputStream fis = new FileInputStream("abc.txt");

		}

		catch (Exception e) {

			System.out.println("entered wrong input");
		}

	}

	static void m1() {

		m2();
	}

	static void m2() {

		m3();

	}

	static void m3() {
		throw new NullPointerException("this is null pointer exception");
	}
}
