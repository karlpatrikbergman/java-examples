package se.patrikbergman.java.eight.doublecolon;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Double colon syntax:
 * Classname::methodname 			if method is static
 * instanceVarName :: methodname 	if method is non static
 */
public class DoubleColonTest {

	static void doSomeStaticWork() {
		System.out.println("Doing som static work");
	}

	@Test
	public void runnableWithDoubleColonOperatorAndStaticWorker() {
		Runnable runnable = DoubleColonTest::doSomeStaticWork;
		runnable.run();
	}

	class Worker {
		void doSomeInstanceWork() {
			System.out.println("Doing some instance work");
		}
	}

	@Test
	public void runnableWithDoubleColonOperatorAndInstanceWorker() {
		Worker worker = new Worker();
		Runnable runnable = worker::doSomeInstanceWork;
		runnable.run();
	}


	/**
	 * Functional interfaces can be represented by Lambda expressions
	 * Runnable is a functional interface (previously Single Argument Interfaces, SAM)
	 */
	@Test
	public void runnableRepresentedByLambdaExpression() {
		Runnable runnable = () -> System.out.println("Hello from runnable!");
		runnable.run();
	}

	/****/

	/**
	 * Can be replaced by Consumer!
	 */
	interface Command<T> {
		void execute(T argument);
	}

	@Test
	public void customFunctionalInterfaceRepresentedByMethodReference() {
		Command command = System.out::println;
		command.execute("Executing command");
	}

	/****/

	class Scrambler {
		String scramble(String string) {
			final List<Character> characterList = Lists.newArrayList(Chars.asList(string.toCharArray()));
			final List<String> stringList = characterList
				.stream()
				.map((character) -> Character.toString(character))
				.collect(Collectors.toList());
			Collections.shuffle(stringList);
			return stringList.stream().collect(Collectors.joining());
		}
	}

	@Test
	public void functionRepresentedByInstanceMethodReference() {
		Scrambler scrambler = new Scrambler();
		Function<String, String> function = scrambler::scramble;
		System.out.println(function.apply("Patrik Bergman"));
	}


	/****/

	/**
	 * Peculiar example
	 */
	public interface Callable<T> {
		public T call();
	}

	@Test
	public void callMe() {
		Callable<String> strCallable = () -> "Hello world";
		System.out.println(strCallable.call());
	}
}
