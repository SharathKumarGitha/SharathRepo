package com.dss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Emp {

	@Override
	public int hashCode() {
		return Objects.hash(eid, ename);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return Objects.equals(eid, other.eid) && Objects.equals(ename, other.ename);
	}

	Integer eid;

	String ename;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Emp(Integer eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	public Emp() {

		System.out.println("this is default constructor....");

	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + "]";
	}
}

class Emp2 {

}

public class SortUserDefinedObjectExample {

	public static void main(String[] args) {

		List<Emp> list = new ArrayList<Emp>();

		list.add(new Emp(5, "sharath"));

		list.add(new Emp(2, "anu"));

		list.add(new Emp(1, "rashmika"));

		list.add(new Emp(4, "sharanya"));

		list.stream().sorted((i1, i2) -> i1.ename.compareTo(i2.ename)).forEach(emp -> System.out.println(emp));

		System.out.println("========================================");

		list.sort(Comparator.comparing(Emp::getEid));

		System.out.println(list);

		System.out.println("=================");

		list.stream().filter(emp -> emp.ename.startsWith("sh")).forEach(emp -> System.out.println(emp));

		System.out.println("=============================");

		Emp emp_with_sh = list.stream().filter(emp -> emp.ename.startsWith("sh")).findFirst().get();

		System.out.println(emp_with_sh);

		System.out.println("==================================");

		List<Integer> list_with_int = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		list_with_int.stream().filter(i -> i % 2 == 0).map(i -> i + 2).forEach(value -> System.out.println(value));

		System.out.println("======================");

		list.stream().filter(emp -> emp.ename.startsWith("sh")).

				map(emp -> {
					emp.setEid(emp.getEid() + 2);
					return emp;
				}).forEach(emp -> System.out.println(emp));

		System.out.println("=====================");

		List<Integer> list_with_eid = list.stream().map(Emp::getEid).collect(Collectors.toList());

		System.out.println(list_with_eid);

	}

}
