package com.dss;

import java.util.ArrayList;

public class ArrayListProtectedRangeMethodExample extends ArrayList<Integer> {

	public void m1() {
		ArrayListProtectedRangeMethodExample l1 = new ArrayListProtectedRangeMethodExample();

		l1.add(10);

		l1.add(20);

		l1.add(30);

		l1.add(40);

		l1.add(50);

		l1.add(60);

		l1.add(70);

		System.out.println(l1);

		l1.removeRange(0, 3);

		

		l1.forEach(num -> System.out.println(num));
		
		l1.replaceAll(num ->num+2);
		
		System.out.println(l1);

	}

	public static void main(String[] args) {

		ArrayListProtectedRangeMethodExample obj = new ArrayListProtectedRangeMethodExample();

		obj.m1();

	}

}
