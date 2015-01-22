package se.patrikbergman.java.eight.lambda.fizz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzFuzzStreamApp {

	public static void main(String args[]) {

		List<Integer> integers = IntStream.range(0, 100).boxed().collect(Collectors.toList());
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
}
