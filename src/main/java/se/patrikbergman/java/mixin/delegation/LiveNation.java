package se.patrikbergman.java.mixin.delegation;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

class LiveNation implements BookingService {

	Map<String, String> bookableMap = new HashMap<>();

	@Override
	public String book(final String itemName) {
		final DateTime bookingDate = DateTime.now();
		final String pattern = "yyyy-MM-dd";
		final String bookingDateString = bookingDate.toString(pattern);
		final String randomString = RandomStringUtils.randomAlphanumeric(5);
		final String bookingId = String.format("%s_%s_%s", itemName, bookingDateString, randomString);
		bookableMap.put(bookingId, itemName);
		return bookingId;
	}

	@Override
	public void cancel(String bookingId) {
		bookableMap.remove(bookingId);
	}

	@Override
	public boolean confirmBooking(String bookingId) {
		return bookableMap.containsKey(bookingId);
	}
}
