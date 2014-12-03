package se.patrikbergman.java.utility.resource;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ResourceInputStreamStringTest {

	public ExpectedException thrown = ExpectedException.none();
	private final String resourceOnClassPath = "environment.properties";

	@Test
	public void getStringFromInputStream() throws IOException {
		final String string = new ResourceInputStreamString(new ResourceInputStream(resourceOnClassPath)).toString();
		assertNotNull(string);
		System.out.println(string);
	}
}
