package se.patrikbergman.java.eight.functionalinterface.example1;

public interface Swimmer {
	default void swim() {
		System.out.println("I'm swimming");
	}
}
