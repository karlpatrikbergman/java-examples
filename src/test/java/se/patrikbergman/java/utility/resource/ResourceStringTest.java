package se.patrikbergman.java.utility.resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ResourceStringTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	private final String resourceOnClassPath = "environment.properties";
	private final String nonExistingResource = "non-existing-path";

	@Test
	public void getStringFromResourceOnClasspath() throws IOException {
		final String string = new ResourceString(resourceOnClassPath).toString();
		assertNotNull(string);
	}

	@Test
	public void getNonExistingResource() throws IOException {
		thrown.expect(IOException.class);
		final String string = new ResourceString(nonExistingResource).toString();
	}
}
