package se.patrikbergman.java.utility.resource;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.util.Properties;

//TODO: Test inherit Properties
public class InputStreamProperties {

	private final Properties properties;

	public InputStreamProperties(ResourceInputStream resourceInputStream) throws IOException {
		Preconditions.checkNotNull(resourceInputStream);
		this.properties = new Properties();
		this.properties.load(resourceInputStream.getInputStream());
	}

	public Properties getProperties() {
		return properties;
	}
}
