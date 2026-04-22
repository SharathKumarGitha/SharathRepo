package com.dss;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> names = new LinkedList<>();

		names.add("sharath");

		names.add("shashi");

		names.add("shankar");

		names.add("ravi");

		names.add("mahesh");

		names.add("shankar");

		System.out.println(names);
		
		System.out.println("===============================");

		names.addFirst("suguna");

		names.addLast("odelu");

		System.out.println("after adding new names into linkedlist...." + names);

		names.add(0, "arjun reddy");

		System.out.println("after adding arjun reddy...." + names);

		int index_of_shankar = names.indexOf("shankar");

		System.out.println(index_of_shankar);

		int lastindex_of_shankar = names.lastIndexOf("shankar");

		System.out.println(lastindex_of_shankar);

		System.out.println("===============================");

		System.out.println(names);

		System.out.println(names.peek());
		

		// System.out.println(names.element());

		System.out.println(names);

		System.out.println(names.poll());

		System.out.println(names);

		System.out.println("===============================");

		System.out.println(names.poll());

		System.out.println(names);

		System.out.println(names.pollFirst());

		System.out.println(names.pollLast());

		System.out.println(names);

		System.out.println("=====================");

		LinkedList<Integer> l2 = new LinkedList<>();

		l2.add(1);

		l2.add(2);

		l2.add(3);

		l2.add(4);

		l2.add(5);

		l2.add(5);

		l2.add(5);

		l2.add(5);

		l2.addFirst(100);

		l2.addLast(200);

		System.out.println(l2);

		System.out.println(l2.poll());

		System.out.println("l2 elements"+ l2);

		System.out.println(l2.peekFirst());

		System.out.println(l2.peekLast());

		if (l2.removeFirstOccurrence(5)) {
			System.out.println("yes element is removed....");
		}

		if (l2.removeLastOccurrence(5)) {
			System.out.println("last occurance is also removed....");
		}

		System.out.println(l2);

		System.out.println("==========================");

	}

}
