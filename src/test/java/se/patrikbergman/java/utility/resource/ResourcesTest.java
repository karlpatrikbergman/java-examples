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
		InputStream inputStream = new ResourceInputStream(resourceOnClassPath).getInputStream();
		assertNotNull(inputStream);
	}

	@Test
	public void getPropertiesFromResourceOnClasspath() throws IOException {
		final Properties properties = new ResourceProperties(resourceOnClassPath).getProperties();
		assertNotNull(properties);
	}

	@Test
	public void getStringFromInputStream() throws IOException {
		final String string = new ResourceInputStreamString(new ResourceInputStream(resourceOnClassPath)).getString();
		assertNotNull(string);
	}

	@Test
	public void getNonExistingResource() throws IOException {
		thrown.expect(IOException.class);
		new ResourceInputStream("non-existing-path");
	}
}
