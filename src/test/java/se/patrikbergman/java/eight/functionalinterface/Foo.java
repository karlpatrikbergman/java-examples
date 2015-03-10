package se.patrikbergman.java.eight.functionalinterface;

import org.junit.Test;

public class Foo {

	//In Java 7

	@Test
	public void giveMeSomeItaloDisco() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				sayHello();
			}
		}).start();
	}

	//In Java 8

	/**
	 * Thread constructor expects SAM/functional interface, which can
	 * be represented by Lambda Expression:
	 *
	 * Runnable r = () -> sayHello();
	 */
	@Test
	public void giveMeSomeItaloDiscoJava8() {
		new Thread(
				() -> sayHello()
		).start();
	}

	public void sayHello() {
		System.out.println("International Music System");
	}


}
