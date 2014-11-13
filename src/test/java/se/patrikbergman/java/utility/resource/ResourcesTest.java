package se.patrikbergman.java.utility.resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

public class ResourcesTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private final String resourceOnClassPath = "environment.properties";

	@Test
	public void getInputStreamFromResourceOnClasspath() throws IOException {
		final ResourceInputStream resourceInputStream = new ResourceInputStream(resourceOnClassPath);
		InputStream inputStream = resourceInputStream.getInputStream();
		assertNotNull(inputStream);
	}

	@Test
	public void getPropertiesFromInputStream() throws IOException {
		final Properties properties =
				new InputStreamProperties(
						new ResourceInputStream(resourceOnClassPath)
				).getProperties();
		assertNotNull(properties);
	}

	@Test
	public void getStringFromInputStream() throws IOException {
		final String string =
				new InputStreamString(
						new ResourceInputStream(resourceOnClassPath)
				).getString();
		assertNotNull(string);
	}

	@Test
	public void getNonExistingResource() throws IOException {
		thrown.expect(IOException.class);
		new ResourceInputStream("non-existing-path");
	}
}
