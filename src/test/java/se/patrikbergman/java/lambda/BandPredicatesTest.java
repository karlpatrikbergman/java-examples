package se.patrikbergman.java.lambda;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.JsonString;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BandPredicatesTest {

	private final List<Band> bands = new ArrayList<>();

	public BandPredicatesTest() {
		bands.add(new Band("Accept", "One of Germany's earliest Speed Metal bands", 8));
		bands.add(new Band("Judas Priest", "One of the most influential heavy metal bands of the '70s, and the one " +
				"that spearheaded the New Wave of British Heavy Metal late in the decade", 9));
		bands.add(new Band("Dream Theatre", "Dynamic American progressive rock band, characterized by slick time " +
				"changes and impeccable musicianship", 3));
		bands.add(new Band("Iron Maiden", "At the forefront of the New Wave of British Heavy Metal, and a major metal " +
				"contender from the late '70s into the 21st century", 10));
		bands.add(new Band("SlipNot", "Appealing to the Korn/Limp Bizkit axis, masked metalheads Slipknot churn out " +
				"brutal, agitated, noisy rock", 2));
	}

	@Test
	public void filterHeavyMetalBands() throws IOException {
		List<Band> heavyMetalBands = BandPredicates.filterHeavyMetalBands(bands, BandPredicates.isHeavyMetalBand());
		assertEquals(3, heavyMetalBands.size());
		System.out.println(new JsonString(heavyMetalBands));
	}
}
