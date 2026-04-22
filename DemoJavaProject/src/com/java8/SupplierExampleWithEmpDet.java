package com.java8;

import java.util.Arrays;
import java.util.function.Supplier;

public class SupplierExampleWithEmpDet {

	static Supplier<EmpDetails> s1 = () -> new EmpDetails(100, "arjun", 50000, Arrays.asList("eating,sleeping"),"M");

	public static void main(String[] args) {

		System.out.println(s1.get());

	}

}
