package se.patrikbergman.java.mixin.delegation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DelegateTest {

	private Bookable bookable;

	@Before
	public void setup() {

		bookable = new Band.Builder()
				.name("Afghan Whigs")
				.description("The Afghan Whigs are an American rock band from Cincinnati, Ohio.")
				.rockFactor(10)
				.bookingService(new BookingService())
				.build();
	}

	@Test
	public void bookBand() {
		final String bookingId = bookable.book();
		assertNotNull(bookingId);
		System.out.println(bookingId);
	}
}
