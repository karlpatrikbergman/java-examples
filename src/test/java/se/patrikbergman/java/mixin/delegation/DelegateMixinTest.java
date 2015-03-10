package se.patrikbergman.java.mixin.delegation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DelegateMixinTest {

	private Band afganWhigs;
	private Poet edgarAllanPoe;
	private List<Bookable> bookables;

	@Before
	public void setup() {
		final BookingService bookingService = new LiveNation();
		afganWhigs = new Band.Builder()
			.name("Afghan Whigs")
			.description("The Afghan Whigs are an American rock band from Cincinnati, Ohio.")
			.rockFactor(10)
			.bookingService(bookingService)
			.build();
		edgarAllanPoe = new Poet.Builder()
			.name("Edgar Allan Poe")
			.description("Edgar Allan Poe was an American author, poet, editor, and literary critic, considered part " +
					"of the American Romantic Movement.")
			.artFactor(12)
			.bookingService(bookingService)
			.build();
		bookables = new ArrayList<>();
		Collections.addAll(bookables, afganWhigs, edgarAllanPoe);
	}

	@Test
	public void bookBandAndHaveItPlay() {
		commontTest(afganWhigs);
	}

	@Test
	public void bookPoetAndHaveHenRead() {
		commontTest(edgarAllanPoe);
	}

	private void commontTest(final Bookable bookable) {
		bookable.book();
		assertNotNull(bookable.getBookingId());
		assertTrue(bookable.confirmBooking());
		bookable.cancel();
		assertFalse(bookable.confirmBooking());
		bookable.book();
		bookable.perform();
	}

	@Test
	public void cancelAllBookables() {
		afganWhigs.book();
		edgarAllanPoe.book();
		bookables.forEach((bookable) -> assertTrue(bookable.confirmBooking()));
		bookables.stream().forEach(Bookable::cancel);
		bookables.forEach((bookable) -> assertFalse(bookable.confirmBooking()));
	}
}
