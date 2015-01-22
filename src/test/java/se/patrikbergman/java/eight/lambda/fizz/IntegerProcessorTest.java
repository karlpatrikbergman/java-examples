package se.patrikbergman.java.eight.lambda.fizz;

import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class IntegerProcessorTest {

	List<Integer> integers = IntStream.range(0, 100).boxed().collect(Collectors.toList());

	/** Actual test **/
	@Test
	public void fizzFuzzIntegersToString() throws IOException {
		final String actualString = IntegerProcessor.fizzFuzzIntegersToString(integers);
		final String expectedString = new ResourceString("fizzfuzz").toString();
		assertEquals(expectedString, actualString);
	}

	@Test
	public void processIntegers() {
		IntegerProcessor.printIntegersMappedToFunction(integers, i -> {
			if (i % 3 == 0 && i % 5 == 0)
				return "FizzFuzz";
			if (i % 3 == 0)
				return "Fizz";
			if (i % 5 == 0)
				return "Fuzz";
			return Integer.toString(i);
		});
	}

	@Test
	public void fizzFuzzIntegers() {
		IntegerProcessor.fizzFuzzIntegers(integers);
	}


}
