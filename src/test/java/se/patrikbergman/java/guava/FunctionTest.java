package se.patrikbergman.java.guava;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Function<A, B>
 *     Transforms A to B
 *
 * Collections2.transform(List<A>, F<A,B)
 * 		Transforms List<A> to List<B>
 */
public class FunctionTest {

	private final Function<Band, InvertedBand> invertBandFunction = new Function<Band, InvertedBand>() {

		@Override
		public InvertedBand apply(Band band) {
			return new InvertedBand(reverse(band.getName()), reverse(band.getDescription()), reverse(band.getRockFactor()));
		}

		private String reverse(String str) {
			return new StringBuffer(str).reverse().toString();
		}

		private int reverse(int i) {
			return 10-i;
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
	public void invertBands() {
		final List<InvertedBand> invertedBands = Lists.newArrayList(Collections2.transform(bands, invertBandFunction));
		System.out.println(invertedBands);
	}
}
