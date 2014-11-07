package se.patrikbergman.java.guava;

import org.junit.Test;

public class PreconditionTest {

	@Test(expected = NullPointerException.class)
	public void createBandWithNameNull() {
		Band band = new Band(null, "Description", 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createBandWithRockFactor100() {
		Band band = new Band("", "", 100);
	}

	@Test
	public void createBand() {
		Band band = new Band("Iron Maiden", "New Wave Of British Heavey Metal", 9);
	}

}
