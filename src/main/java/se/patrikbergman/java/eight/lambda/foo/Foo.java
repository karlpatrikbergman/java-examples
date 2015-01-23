package se.patrikbergman.java.eight.lambda.foo;

import java.util.function.Function;
import java.util.function.Predicate;

public class Foo {

	public static void main(String args[]) {
		firstOrderFunction();

	}


	private static void firstOrderFunction() {

		Function<String, Function<Integer, Boolean>> f = new Function<String, Function<Integer, Boolean>>() {

			@Override
			public Function<Integer, Boolean> apply(String string) {
				return new Function<Integer, Boolean>() {
					@Override
					public Boolean apply(Integer integer) {
						return integer == Integer.parseInt(string);
					}
				};
			}
		};

		Function<Integer, Boolean> g = f.apply("100");
		System.out.println(g.apply(100));
	}

	private static void executeFunctionTest() {
		Function<Integer, String> f = new Function<Integer, String>() {
			@Override
			public String apply(Integer integer) {
				return Integer.toString(integer);
			}
		};
		Function<Integer, String> ff = i -> Integer.toString(i);

		System.out.println(f.apply(5));
		System.out.println(ff.apply(5));
	}


	private static void executePredicateTest() {
		Predicate<Integer> p = new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				return integer % 2 == 0;
			}
		};
		//above equals below
		Predicate<Integer> pp = (Integer i) -> i % 2 == 0;

		System.out.println(p.test(4));
		System.out.println(pp.test(4));


	}
}
