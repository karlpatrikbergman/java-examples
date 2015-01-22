package se.patrikbergman.java.eight.lambda.fizz;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzFuzzPredicateAndFunctionApp {

	public static void main(String args[]) {

		List<Integer> integers = IntStream.range(0, 100).boxed().collect(Collectors.toList());

		Predicate<Integer> fizz = new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				return integer % 3 == 0;
			}
		};

		Predicate<Integer> fuzz = new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				return integer % 5 == 0;
			}
		};

		Predicate<Integer> fizzFuzz = new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				return (integer % 3 == 0) && (integer % 5 == 0);
			}
		};

		Function<Integer, String> fizzFuzzFizzFuzz = new Function<Integer, String>() {
			@Override
			public String apply(Integer integer) {
				if (fizzFuzz.test(integer)) return "FizzFuzz";
				if(fizz.test(integer)) return "Fizz";
				if (fuzz.test(integer)) return "Fuzz";
				return Integer.toString(integer);
			}
		};

		processIntegers(integers, fizzFuzzFizzFuzz);

		//Predicates and Functions above equals to
		/*
		printIntegersMappedToFunction(integers, i -> {
			if (i % 3 == 0 && i % 5 == 0)
				return "FizzFuzz";
			if (i % 3 == 0)
				return "Fizz";
			if (i % 5 == 0)
				return "Fuzz";
			return Integer.toString(i);
		});
		*/
		//Se FizzFuzzStreamApp
	}

	public static void processIntegers(List<Integer> integers, Function<Integer, String> mapper) {
		for(Integer integer: integers) {
			System.out.println(mapper.apply(integer));
		}
	}
}
