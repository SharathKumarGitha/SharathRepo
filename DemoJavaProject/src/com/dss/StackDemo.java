package com.dss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();

		stack.push("sharath");

		stack.push("shashi");

		stack.push("sampath");

		stack.push("kalyani");

		System.out.println(stack);

		String pop_value = stack.pop();

		System.out.println(pop_value);

		System.out.println(stack);

		System.out.println(stack.search("shashi"));

		System.out.println("=================");

		Stack<String> stk = new Stack<>();
		// pushing elements into Stack
		stk.push("Mac Book");
		stk.push("HP");
		stk.push("DELL");
		stk.push("Asus");
		System.out.println("Stack: " + stk);
		// Search an element
		int location = stk.search("HP");
		System.out.println("Location of Dell: " + location);

		System.out.println("=======================");

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}

		System.out.println(list);

		Iterator<Integer> itr = list.iterator();

		while (itr.hasNext()) {
			Integer value = itr.next();

			if (value % 2 == 0) {
				System.out.println(value);
			} else {
				itr.remove();
			}
		}

		System.out.println(list);

		System.out.println("===================");

		List<String> names = new ArrayList<String>();

		names.add("sharath");

		names.add("shashi");

		names.add("mahesh");

		names.add("kalyan");

		names.add("sam");

		Iterator<String> list_itr = names.iterator();

		while (list_itr.hasNext()) {
			String str = (String) list_itr.next();

			if (str.equals("mahesh")) {

				list_itr.remove();
			}

		}

		System.out.println(names);

	}
}
