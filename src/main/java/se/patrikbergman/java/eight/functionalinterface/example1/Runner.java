package se.patrikbergman.java.eight.functionalinterface.example1;

public interface Runner {
	default void run() {
		System.out.println("I'm running");
	}
}
