package se.patrikbergman.java.guava;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Predicate<A>
 *     Returns true/false depending on some property of A
 *
 * Collections2.filter(List<A>, P<A)
 * 		Filters List<A> to List<A> for all A:s that for wich P<A> == true
 */


public class PredicateTest {

	private final Predicate<Band> heavyMetalFilter = new Predicate<Band>() {
		@Override
		public boolean apply(Band band) {
			return band.getRockFactor() >= 8;
		}
	};

	private final ImmutableList<Band> bands = ImmutableList.<Band>builder()
			.add(new Band("Strong Mint", "Chewing-gum-rock", 1))
			.add(new Band("Clean Code", "Developer-rock", 2))
			.add(new Band("Stadium", "Sports-rock", 3))
			.add(new Band("Judas Priest", "New Wave Of British Heavy Meatal", 8))
			.add(new Band("Iron Maiden", "New Wave Of British Heavey Metal", 9))
			.build();

	@Test
	public void filterBands() {
		final List<Band> heavyMetalBands = Lists.newArrayList(Collections2.filter(bands, heavyMetalFilter));
		System.out.println(heavyMetalBands);
	}

	@Test
	public void filterOutNullValues() {
		List<String> listwithNullValues = Lists.newArrayList("one", null, null, "four");
		List<String> listNoNullValues = Lists.newArrayList(Collections2.filter(listwithNullValues, Predicates.notNull()));
		assertTrue(Iterables.all(listNoNullValues, Predicates.notNull()));
	}

}