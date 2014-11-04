package se.patrikbergman.java.utility;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertNotNull;

public class UnicodeFileTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void instantiation() throws URISyntaxException, FileNotFoundException {
		UnicodeFile unicodeFile = new UnicodeFile("names.txt", "UTF-8");
		assertNotNull(unicodeFile);
		assertNotNull(unicodeFile.getPath());
		assertNotNull(unicodeFile.getCharset());
		System.out.println(unicodeFile);
	}

	@Test
	public void fileNotFound() throws URISyntaxException, FileNotFoundException {
		thrown.expect(FileNotFoundException.class);
		UnicodeFile unicodeFile = new UnicodeFile("should_not_exist.txt", "UTF-8");
	}
}
