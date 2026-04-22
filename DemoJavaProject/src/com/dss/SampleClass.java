package com.dss;

//Superclass
class Animal {
	String name;

	public Animal(String name) {
		this.name = name;
		System.out.println("Animal constructor called: " + name);
	}
}

//Subclass
class Dog extends Animal {
	String breed;

	public Dog(String name, String breed) {
		super(name); // Calls Animal's constructor
		this.breed = breed;
		System.out.println("Dog constructor called: " + breed);
	}
}

public class SampleClass {

	int age;

	String name;

	static String college;

	public void m1() {
		System.out.println(age + " " + name + " " + college);
	}

	public static void main(String[] args) {

		Animal animal = new Dog("charlie", "Beagle");

		SampleClass class1 = new SampleClass();

		class1.age = 22;

		class1.name = "shashi";

		class1.college = "RGUKT BASAR";

		class1.m1();

		SampleClass class2 = new SampleClass();

		class2.age = 23;

		class2.name = "sampath";

		class2.m1();

	}

}
