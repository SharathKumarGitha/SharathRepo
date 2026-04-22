package com.dss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

class Student {
	private Integer id;

	private String name;

	private String school;

	public Student(Integer id, String name, String school) {
		this.id = id;
		this.name = name;
		this.school = school;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, school);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(school, other.school);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + "]";
	}

}

class Op implements UnaryOperator<Student> {

	// t.getSchool().replace("s", "zphs malkapoor")

	@Override
	public Student apply(Student t) {

		Student s1 = new Student(t.getId(), t.getName(),

				t.getSchool().replaceAll("(.*)s(.*)", "zphs malkapoor"));
		return s1;
	}

}

public class ArrayListWithUserDefinedClass {

	public static void main(String[] args) {

		ArrayList<Student> list1 = new ArrayList<>();

		Student s1 = new Student(123, "sharath", "s1");

		Student s2 = new Student(124, "shashi", "s2");

		Student s3 = new Student(125, "manoj", "s3");

		Student s4 = new Student(126, "maha", "s4");

		list1.add(s1);

		list1.add(s2);

		list1.add(s3);

		list1.add(s4);

		System.out.println(list1);

		if (!list1.isEmpty()) {
			System.out.println("list is not empty");
		} else {
			System.out.println("list is empty....");
		}

		System.out.println("======================");

		Student s5 = new Student(123, "sharath", "s1");

		if (list1.contains(s5)) {
			System.out.println("yes object is there");
		} else {
			System.out.println("object is not there...");
		}

		System.out.println("=================");

//		boolean b = list1.remove(s5);
//
//		if (b) {
//			System.out.println("yes s5 is deleted...");
//		}
//
//		System.out.println(list1);

		System.out.println("=================================");

		System.out.println("before list...");

		System.out.println(list1);

		Student sobj = list1.set(2, s5);

		System.out.println(sobj);

		System.out.println(list1);
		System.out.println("======================");

		list1.stream().map(v1 -> {
			v1.setName(v1.getName().concat("kumar"));
			return v1;
		}).

				forEach(v2 -> System.out.println(v2));

		System.out.println("=============================");

		list1.stream().map(v1 -> {
			v1.setId(v1.getId() + 2);
			return v1;
		}).

				forEach(v2 -> System.out.println(v2));

		System.out.println("====================");

		list1.replaceAll(new Op());

		System.out.println(list1);

		System.out.println("=========================");

		Student object1 = list1.get(0);

		System.out.println(object1);

		int index_value = list1.indexOf(object1);

		System.out.println(index_value);

		System.out.println("====================================");

		list1.removeIf(del -> del.getName().startsWith("shashi"));

		System.out.println(list1);

		System.out.println("=======================");

		List<Student> list2 = list1.stream().filter(n1 -> n1.getId() < 130).collect(Collectors.toList());

		System.out.println(list2);

		ArrayList<Student> list3 = new ArrayList<Student>(list2);

		if (list1.equals(list3)) {
			System.out.println("both are equal");
		} else {
			System.out.println("not equal...");
		}

		System.out.println("==============");
		
		
		

	}

}
