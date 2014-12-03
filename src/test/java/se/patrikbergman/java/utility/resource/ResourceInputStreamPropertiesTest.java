package se.patrikbergman.java.utility.resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResourceInputStreamPropertiesTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	private final String resourceOnClassPath = "environment.properties";
	private final String nonExistingResource = "non-existing-path";

	@Test
	public void getPropertiesFromResourceInputStream() throws IOException {
		Properties properties = new ResourceInputStreamProperties(new ResourceInputStream(resourceOnClassPath));
		assertNotNull(properties);
		assertEquals("bar", properties.getProperty("foo"));
	}

	@Test
	public void getNonExistingResource() throws IOException {
		thrown.expect(IOException.class);
		Properties properties = new ResourceInputStreamProperties(new ResourceInputStream(nonExistingResource));
	}
}
