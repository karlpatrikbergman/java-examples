package se.patrikbergman.java.sorting.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

	@Test
	public void comparatorRepresentedByLambdaExpression() {
		List<Band> bandList = new ArrayList<>();
		Collections.addAll(bandList,
				new Band("Judas Pries", 120),
				new Band("Saxon", 90),
				new Band("Scorpions", 12),
				new Band("Accept", 100));
		Comparator<Band> comparator = (b1, b2) -> b2.getRockFactor() - b1.getRockFactor();
		Collections.sort(bandList, comparator);
		bandList.stream().forEach(System.out::println);
	}
}
