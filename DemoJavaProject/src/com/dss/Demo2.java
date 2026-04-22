package com.dss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

abstract class Sample1 {
	abstract void m1();

	abstract void m2();

	abstract void m3();

	public void m4() {

		System.out.println("this  is m4 method....");
	}
}

interface i1 {

	public void i1_m1();

	public void i2_m2();

	public void i3_m3();

	public void i4_m4();
}

class Adptor implements i1 {

	@Override
	public void i1_m1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void i2_m2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void i3_m3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void i4_m4() {
		// TODO Auto-generated method stub

	}

}

class Test extends Adptor {

	public void m1() {
		System.out.println("this is m1 method in the Test class");
	}

	public void m2() {
		System.out.println("this is m2 method in the Test class");
	}
}

public class Demo2 extends Sample1 {

	public void m1() {
		System.out.println("this is m1 method");
	}

	public void m2() {
		System.out.println("this is m2 method");
	}

	public void m3() {
		System.out.println("this is m3 method");
	}

	public static void main(String[] args) throws IOException {

		Demo2 demo2 = new Demo2();

		demo2.m1();

		demo2.m2();

		demo2.m3();

		demo2.m4();

		System.out.println("============================");

		Test test = new Test();

		test.m1();

		test.m2();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("enter name");

		String name = reader.readLine();

		System.out.println("enter age");

		int age = Integer.parseInt(reader.readLine());

		System.out.println("my name is " + name + " my age is " + age);

		while (true) {
			Scanner scanner = new Scanner(System.in);

			System.out.println("enter emp no");

			int emp_no = scanner.nextInt();

			System.out.println("enter emp name");

			String emp_name = scanner.next();

			System.out.println("enter emp company");

			String company = scanner.next();

			System.out.println("emp no is" + emp_no);

			System.out.println("emp name is " + emp_name);

			System.out.println("emp company is..." + company);

			System.out.println("enter one more record(yes/no)");

			String option = scanner.next();

			if (option.equals("no")) {
				break;
			}

		}

	}

}
