package se.patrikbergman.java.mixin.delegation;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

/**
 * Reusable booking service.
 */
class BookingService {

	public String book(final String itemName) {
		final DateTime bookingDate = DateTime.now();
		final String pattern = "yyyy-MM-dd";
		final String bookingDateString = bookingDate.toString(pattern);
		final String randomString = RandomStringUtils.randomAlphanumeric(5);
		return String.format("%s_%s_%s", itemName, bookingDateString, randomString);
	}
}
