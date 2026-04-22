package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmpDatabase {

	public static List<EmpDetails> getAllEmpDet() {

		List<EmpDetails> list = new ArrayList<>();

		EmpDetails emp1 = new EmpDetails(100, "sharath", 20000, Arrays.asList("eating", "sleeping"),"M");

		EmpDetails emp2 = new EmpDetails(200, "sunny", 25000, Arrays.asList("chess", "eating"),"M");

		EmpDetails emp3 = new EmpDetails(300, "anu", 320000, Arrays.asList("skating", "eating"),"F");

		EmpDetails emp4 = new EmpDetails(400, "mahesh", 43000, Arrays.asList("runnning", "sleeping"),"M");

		EmpDetails emp5 = new EmpDetails(500, "shankar", 50000, Arrays.asList("volleyball", "waiting"),"M");

		EmpDetails emp6 = new EmpDetails(600, "alekya", 75000, Arrays.asList("going", "chess"),"F");

		list.add(emp1);

		list.add(emp2);

		list.add(emp3);

		list.add(emp4);

		list.add(emp5);

		list.add(emp6);

		return list;
	}
}
