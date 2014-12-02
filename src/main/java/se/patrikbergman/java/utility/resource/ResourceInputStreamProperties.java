package se.patrikbergman.java.utility.resource;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.util.Properties;

//TODO: Test inherit Properties
public class ResourceInputStreamProperties {

	private final Properties properties;

	public ResourceInputStreamProperties(final ResourceInputStream resourceInputStream) throws IOException {
		Preconditions.checkNotNull(resourceInputStream);
		this.properties = new Properties();
		this.properties.load(resourceInputStream.getInputStream());
	}

	public Properties getProperties() {
		return properties;
	}
}
