package se.patrikbergman.java.mixin.delegation;

public interface BookingService {
	public String book(final String itemName);
	public void cancel(final String bookingId);
	public boolean confirmBooking(final String bookingId);
}
