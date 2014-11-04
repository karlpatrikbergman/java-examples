package se.patrikbergman.java.utility;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertNotNull;

public class UnicodeFileTest {


	@Test
	public void instantiation() throws URISyntaxException {
		UnicodeFile unicodeFile = new UnicodeFile("names.txt", "UTF-8");
		assertNotNull(unicodeFile);
		assertNotNull(unicodeFile.getPath());
		assertNotNull(unicodeFile.getCharset());
		System.out.println(unicodeFile);
	}
}
