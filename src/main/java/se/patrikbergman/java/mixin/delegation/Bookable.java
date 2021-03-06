package se.patrikbergman.java.mixin.delegation;

public interface Bookable {
	String book();
	void cancel();
	boolean confirmBooking();
	String getBookingId();
	void perform();
}
