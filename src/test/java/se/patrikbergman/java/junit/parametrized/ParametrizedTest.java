package se.patrikbergman.java.junit.parametrized;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import se.patrikbergman.java.junit.*;

import java.util.Arrays;
import java.util.Collection;


/**
 * Example of parametrized test
 */

@RunWith(Parameterized.class)
public class ParametrizedTest {

	private final Integer input;
	private final Integer expectedOutput;

	public ParametrizedTest(final Integer input, final Integer expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void factorial() {
		final Integer actualResult = se.patrikbergman.java.junit.Math.factorial(input);
		assertEquals(expectedOutput, actualResult);
		System.out.println(String.format("Input: %s. Expected result: %s. Actual result: %s", input, expectedOutput,
				actualResult));
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{1, 1},
				{5, 120},
				{11, 39916800}
		});
	}
}
