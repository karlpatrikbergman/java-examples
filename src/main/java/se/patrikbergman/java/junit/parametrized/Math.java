package se.patrikbergman.java.junit.parametrized;

class Math {

	public static Integer factorial(final Integer number) {
		if (number <= 0) {
			return 1;
		} else {
			return number * factorial(number - 1);
		}
	}
}
