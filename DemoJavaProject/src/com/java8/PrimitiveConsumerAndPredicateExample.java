package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;

public class PrimitiveConsumerAndPredicateExample {

	static IntConsumer c1 = a1 -> System.out.println(a1 * a1);

	static DoubleConsumer d1 = a1 -> System.out.println(a1 * 3);

	static IntPredicate p1 = a1 -> a1 > 10;

	static UnaryOperator<String> u1 = str -> str.toUpperCase();

	static BinaryOperator<String> b1 = (a, b) -> a.concat(b);

	static Comparator<Integer> comp = (a, b) -> a.compareTo(b);

	static UnaryOperator<EmpDetails> u2 = emp -> {
		emp.setHobbies(Arrays.asList("fishing", "sucking"));

		return emp;

	};

	public static void main(String[] args) {

		c1.accept(10);

		d1.accept(3.0);

		System.out.println(p1.test(100));

		System.out.println(u2.apply(SupplierExampleWithEmpDet.s1.get()));
		
		System.out.println("==========================");

		b1.apply("sharath", "kumar");

		BinaryOperator<Integer> bi = BinaryOperator.maxBy(comp);

		System.out.println(bi.apply(5, 6));

		BinaryOperator<Integer> bi2 = BinaryOperator.minBy(comp);

		System.out.println(bi2.apply(7, 100));

	}
}
