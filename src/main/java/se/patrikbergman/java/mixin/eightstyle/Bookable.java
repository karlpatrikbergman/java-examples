package se.patrikbergman.java.mixin.eightstyle;

public interface Bookable {
	default String book() {
		return null;
	}
	void cancel();
	boolean confirmBooking();
	String getBookingId();
	void perform();
}
