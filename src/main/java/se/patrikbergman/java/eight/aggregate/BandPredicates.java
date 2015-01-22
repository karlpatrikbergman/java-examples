package se.patrikbergman.java.eight.aggregate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class BandPredicates {

	static Predicate<Band> isHeavyMetalBand() {
		return b -> b.getRockFactor() >= 8 && !b.getName().startsWith("Ultra");
	}

	static List<Band> filterHeavyMetalBands(final List<Band> bands, final Predicate<Band> heavyMetalPredicate) {
		return bands.stream().filter(heavyMetalPredicate).collect(Collectors.<Band>toList());
	}
}
