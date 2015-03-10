package se.patrikbergman.java.eight.functionalinterface.example1;

public interface Flyer {
	default void fly() {
		System.out.println("I'm flying");
	}
}
