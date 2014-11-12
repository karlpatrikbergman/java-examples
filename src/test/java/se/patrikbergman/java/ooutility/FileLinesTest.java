package se.patrikbergman.java.ooutility;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileLinesTest {

	@Test
	public void instantiation() throws URISyntaxException, IOException {
		FileLines fileLines = new FileLines(
				new UnicodeFile("names.txt", "UTF-8")
		);
		assertNotNull(fileLines);
		assertEquals(7, fileLines.getLines().get(1).length()); //Line with Stella contains white space
		System.out.println(fileLines);
	}
}
