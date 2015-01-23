package se.patrikbergman.java.eight.lambda.foo;

public interface IFoo {
	default String getName() {
		return "DEFAULT_VALUE";
	}
}
