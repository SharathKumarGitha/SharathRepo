package com.java8;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerClassDemo {

	static Consumer<String> c1 = str -> System.out.println("this is..... " + str);

	static Consumer<String> c2 = str -> System.out.println("this is " + str.toUpperCase());

	static Consumer<EmpDetails> empDetCon = emp -> System.out.println(emp);

	static Consumer<EmpDetails> c3 = str -> System.out.println(str.getEname());

	static Consumer<EmpDetails> c4 = str -> System.out.println(str.getHobbies());

	static BiConsumer<Integer, String> bc1 = (b1, b2) -> System.out.println("my eid is " + b1 + " and my name is" + b2);

	public void printEnames() {
		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c3);
	}

	public void printHobbies() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c4);

	}

	public void printNamesWithHobbies() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(c3.andThen(c4));

	}

	public void printNamesWithHobbiesWithCondition() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(emp -> {

			if (emp.getEname().startsWith("s")) {
				c3.andThen(c4).accept(emp);
			}
		});

	}

	public void printEidandNamesWithBiConsumer() {

		List<EmpDetails> list = EmpDatabase.getAllEmpDet();

		list.forEach(emp -> {

			if (emp.getSalary() > 25000) {
				bc1.accept(emp.getEid(), emp.getEname());
			}
		});

	}

	public static void main(String[] args) {

		ConsumerClassDemo demo = new ConsumerClassDemo();

		c1.accept("sharath");

		System.out.println("==========================");

		c2.accept("sharath");

		System.out.println("========================");

		demo.printEnames();

		System.out.println("==========================");

		demo.printHobbies();

		System.out.println("=========================");

		demo.printNamesWithHobbies();

		System.out.println("============================");

		demo.printNamesWithHobbiesWithCondition();

		System.out.println("=========================");

		demo.printEidandNamesWithBiConsumer();

	}

}
