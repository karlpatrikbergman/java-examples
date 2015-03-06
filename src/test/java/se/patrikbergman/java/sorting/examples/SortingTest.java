package se.patrikbergman.java.sorting.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingTest {


	@Test
	public void sortInts() {
		int[] ints = {0, 2, 62, 1, 22, 78};
		Arrays.sort(ints);
		System.out.println(Arrays.toString(ints));
	}

	@Test
	public void sortStrings() {
		String[] strings = {"G", "S", "A", "B"};
		Arrays.sort(strings);
		System.out.println(Arrays.toString(strings));
	}

	@Test
	public void sortStringList() {
		String[] strings = {"G", "S", "A", "B"};
		List<String> stringList = Arrays.asList(strings);
		Collections.sort(stringList);
		stringList
			.stream()
			.forEach(System.out::println);
	}
}
