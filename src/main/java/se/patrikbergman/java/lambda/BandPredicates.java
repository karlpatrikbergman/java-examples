package se.patrikbergman.java.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BandPredicates {

	public static Predicate<Band> isHeavyMetalBand() {
		return b -> b.getRockFactor() >= 8 && !b.getName().startsWith("Ultra");
	}

	public static List<Band> filterHeavyMetalBands(final List<Band> bands, final Predicate<Band> heavyMetalPredicate) {
		return bands.stream().filter(heavyMetalPredicate).collect(Collectors.<Band>toList());
	}
}
