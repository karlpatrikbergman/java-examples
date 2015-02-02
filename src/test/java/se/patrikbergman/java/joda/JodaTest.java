package se.patrikbergman.java.joda;

import org.joda.time.DateTime;
import org.junit.Test;

public class JodaTest {

	@Test
	public void dateTimeFormatting() {
//		final String pattern = "E MM/dd/yyyy HH:mm:ss.SSS";
		final String pattern = "yyyy-MM-dd";
		final DateTime dateTime = DateTime.now();
		System.out.println(dateTime.toString(pattern));
	}

}
