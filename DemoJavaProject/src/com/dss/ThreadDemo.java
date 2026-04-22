package com.dss;

class Thread1 extends Thread {

	public void run() {
		System.out.println("this is first thread");
		m1();

		int value = this.m2();

		System.out.println(value);
	}

	public void m1() {

		System.out.println("this is m1 method.....");

	}

	public int m2() {
		return 10;
	}
}

class MyThread extends Thread {

	public void run() {

		for (int i = 1; i <= 5; i++) {

			try {
				System.out.println("this is run method in MyThread class....." + i);
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		Thread1 t1 = new Thread1();

		t1.start();

		System.out.println(t1.currentThread().getName());

		System.out.println(t1.currentThread().getPriority());

		t1.currentThread().setName("sharath");

		String name = t1.currentThread().getName();

		System.out.println(name);

		Thread.currentThread().setName("main Thread man");

		String main_thread = Thread.currentThread().getName();

		System.out.println(main_thread);

		System.out.println("=================================");

		for (int i = 1; i <= 10; i++) {
			System.out.println("this is main thread....");

			Thread.sleep(5000);
		}

		System.out.println("=============================");

		MyThread myThread1 = new MyThread();

		MyThread myThread2 = new MyThread();

		boolean isAlive = myThread1.isAlive();

		System.out.println(isAlive);

		myThread1.start();

		boolean isAlive2 = myThread1.isAlive();

		System.out.println(isAlive2);

		myThread1.join();

		myThread2.start();

	}

}
