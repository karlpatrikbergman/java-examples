package se.patrikbergman.java.evilextendsis2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class ExtendedStackTest {

	private ExtendedStack<Integer> extendedStack;

	@Before
	public void setup() {
		extendedStack = new ExtendedStack<>();
	}

	@Test
	public void pushTwoIntegersAndPopOne() {
		extendedStack.push(1);
		extendedStack.push(10);
		final int latestValue = extendedStack.pop();
		assertEquals(10, latestValue);
		assertEquals(2, extendedStack.getMaxSizeSoFar());
	}

	/**
	 * ExtendedStack used pushMany() from parent class
	 * pushMany() in parent class calls push()
	 * push() is overridden in Extended stack, and counting
	 * of max number of items is added.
	 *
	 * If pushMany() in parent class is changed so that push()
	 * is no longer called, ExtendedStack will no longer work
	 */
	@Test
	public void pushManyAndPopOne() {
		Iterator<Integer> iterator = Arrays.asList(1, 10, 32, 3).iterator();
		extendedStack.pushMany(iterator);
		final int latestValue = extendedStack.pop();
		assertEquals(3, latestValue);
		assertEquals(4, extendedStack.getMaxSizeSoFar());
	}

	@Test
	public void accessThroughFragileBaseStack() {
		FragileBaseStack<Boolean> stack = new ExtendedStack<>();
		Iterator<Boolean> iterator = Arrays.asList(false, false, true, false).iterator();
		stack.pushMany(iterator);
		final boolean lastValue = stack.pop();
		ExtendedStack<Boolean> stackExtended = (ExtendedStack<Boolean>) stack;
		assertEquals(4, stackExtended.getMaxSizeSoFar());
	}
}
