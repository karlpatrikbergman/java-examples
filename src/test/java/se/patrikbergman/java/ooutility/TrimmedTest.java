package se.patrikbergman.java.ooutility;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrimmedTest {

	@Test
	public void instantiation() throws URISyntaxException, IOException {


		final Trimmed trimmed = new Trimmed( 					//Iterates list and creates a new immutable list with trimmed strings
				new FileLines(									//Reads lines in file to immutable list
						new UnicodeFile("names.txt", "UTF-8")	//Gets java.nio.Path-object from classpath
				)
		);
		assertNotNull(trimmed);
		assertEquals(6, trimmed.getTrimmedStrings().get(1).length());
		System.out.println(trimmed);
	}
}
