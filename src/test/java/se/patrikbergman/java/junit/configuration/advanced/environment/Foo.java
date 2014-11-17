package se.patrikbergman.java.junit.configuration.advanced.environment;

import se.patrikbergman.java.utility.resource.ResourceProperties;

import java.io.IOException;
import java.util.Properties;

public class Foo {
	protected Environment getEnvironment() throws IOException {
		final Properties prop = new ResourceProperties("config.properties").getProperties();
		final String envName = getValue(prop, "test.environment", "test");
		return Environment.fromValue(envName);
	}

	protected String getValue(final Properties properties, final String key, final String defaultValue) {
		final String value = properties.getProperty(key);
		return (value.contains("$")) ? defaultValue : value;
	}
}
