package se.patrikbergman.java.utility.resource;

import java.io.IOException;
import java.util.Properties;

public class ResourceProperties {

	private final Properties properties;

	public ResourceProperties(final String resourceOnClasspath) throws IOException {
		this.properties =
				new InputStreamProperties(
						new ResourceInputStream(resourceOnClasspath)
				).getProperties();
	}

	public Properties getProperties() {
		return properties;
	}
}
