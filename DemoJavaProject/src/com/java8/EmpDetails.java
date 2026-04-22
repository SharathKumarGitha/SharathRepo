package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmpDetails {

	private Integer eid;

	private String gender;

	public EmpDetails(Integer eid, String ename, Integer salary, List<String> hobbies, String gender) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.hobbies = hobbies;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "EmpDetails [eid=" + eid + ", gender=" + gender + ", ename=" + ename + ", salary=" + salary
				+ ", hobbies=" + hobbies + "]";
	}

	private String ename;

	private Integer salary;

	private List<String> hobbies;

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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public void printHobbies() {
		System.out.println(this.hobbies);
	}

	public boolean checkName() {

		return this.ename.startsWith("sh");
	}

	public static List<String> getAllNames(List<EmpDetails> empdet) {

		List<String> list = new ArrayList<>();

		{
			for (EmpDetails e1 : empdet) {
				list.add(e1.getEname());

			}

			return list;
		}

	}
}
