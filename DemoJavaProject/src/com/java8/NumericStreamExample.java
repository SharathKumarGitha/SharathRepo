package com.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamExample {

	public static void main(String[] args) {

		int sum = IntStream.rangeClosed(1, 50).sum();

		System.out.println(sum);

		long sum2 = IntStream.rangeClosed(1, 50).asLongStream().sum();

		System.out.println(sum2);

		double avg = IntStream.rangeClosed(1, 50).average().getAsDouble();

		System.out.println(avg);

		System.out.println("=================================");

		List<Integer> list = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());

		System.out.println(list);

		int sum_of = list.stream().mapToInt(e -> e).sum();

		System.out.println(sum_of);

		System.out.println("===========================");
		
		
		Integer sum_with_list=list.stream().reduce((a,b)->a+b).get();
		
		System.out.println(sum_with_list);
		
		System.out.println("=========================");
		

		
		
		

	}

}
