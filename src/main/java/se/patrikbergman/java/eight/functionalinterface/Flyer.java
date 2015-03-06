package se.patrikbergman.java.eight.functionalinterface;

@FunctionalInterface
public interface Flyer extends Mover {
	default void fly() {
		System.out.println("I'm flying");
	};
}
