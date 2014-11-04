package se.patrikbergman.java.comparable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BandComparableTest {
	List<Band> bands = new ArrayList<>();
	{

		bands.add(new Band.Builder()
			.name("Accept")
			.rockFactor(100)
			.build());
		bands.add(new Band.Builder()
				.name("Iron Maiden")
				.rockFactor(101)
				.build());
	}

	@Test
	public void sortComparableBands() {
		Collections.sort(bands);
		System.out.println(bands);
	}
}