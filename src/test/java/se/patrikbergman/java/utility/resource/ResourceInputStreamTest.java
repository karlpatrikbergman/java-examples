package se.patrikbergman.java.utility.resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public class ResourceInputStreamTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	private final String resourceOnClassPath = "environment.properties";
	private final String nonExistingResource = "non-existing-path";

	@Test
	public void getInputStreamFromResourceOnClasspath() throws IOException {
		InputStream inputStream = new ResourceInputStream(resourceOnClassPath);
		assertNotNull(inputStream);
	}

	@Test
	public void getNonExistingResource() throws IOException {
		thrown.expect(IOException.class);
		new ResourceInputStream(nonExistingResource);
	}
}
