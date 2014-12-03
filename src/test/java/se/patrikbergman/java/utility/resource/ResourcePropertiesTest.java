package se.patrikbergman.java.utility.resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

public class ResourcePropertiesTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	private final String resourceOnClassPath = "environment.properties";
	private final String nonExistingResource = "non-existing-path";

	@Test
	public void getPropertiesFromResourceOnClasspath() throws IOException {
		final Properties properties = new ResourceProperties(resourceOnClassPath).getProperties();
		assertNotNull(properties);
	}

	@Test
	public void getNonExistingResource() throws IOException {
		thrown.expect(IOException.class);
		final Properties properties = new ResourceProperties(nonExistingResource).getProperties();
	}
}
