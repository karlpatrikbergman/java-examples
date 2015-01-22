package se.patrikbergman.java.eight.lambda.fizz;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * See unit test
 */
public class IntegerProcessor {

	public static void fizzFuzzIntegers(List<Integer> integers) {
		integers
			.stream()
			.map(i ->  {
				if (i % 3 == 0 && i % 5 == 0)
					return "FizzFuzz";
				if (i % 3 == 0)
					return "Fizz";
				if (i % 5 == 0)
					return "Fuzz";
				return Integer.toString(i);
			})
			.forEach(System.out::println);
	}

	/** A more generic solution **/
	public static void printIntegersMappedToFunction(List<Integer> integers, Function<Integer, String> mapper) {
		integers
				.stream()
				.map(i -> mapper.apply(i))
				.forEach(System.out::println);
	}

	public static String fizzFuzzIntegersToString(List<Integer> integers) {
		final String newLine = System.getProperty("line.separator");
		return
			integers
				.stream()
				.map(i -> {
					if (i % 3 == 0 && i % 5 == 0)
						return "FizzFuzz";
					if (i % 3 == 0)
						return "Fizz";
					if (i % 5 == 0)
						return "Fuzz";
					return Integer.toString(i);
				})
				.collect(Collectors.joining(newLine));
	}
}
