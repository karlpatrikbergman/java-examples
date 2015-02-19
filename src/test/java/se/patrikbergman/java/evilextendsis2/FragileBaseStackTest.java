package se.patrikbergman.java.evilextendsis2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;

public class FragileBaseStackTest {

	FragileBaseStack<String> stack;

	@Before
	public void setup() {
		stack = new FragileBaseStack<String>();
	}

	@Test
	public void pushFourMembersAndPopTwo() {
		stack.push("Paul Mccartney");
		stack.push("John Lennon");
		stack.push("George Harrison");
		stack.push("Ringo Starr");
		final String ringo = stack.pop();
		assertEquals("Ringo Starr", ringo);
		final String george = stack.pop();
		assertEquals("George Harrison", george);
	}

	@Test
	public void pushManyAndPopOne() {
		Iterator<String> iterator = Arrays.asList("John", "Paul", "Ringo", "George").iterator();
		stack.pushMany(iterator);
		final String last = stack.pop();
		assertEquals("George", last);
	}
}
