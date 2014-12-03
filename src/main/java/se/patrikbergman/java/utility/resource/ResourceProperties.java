package se.patrikbergman.java.utility.resource;

import java.io.IOException;
import java.util.Properties;

public class ResourceProperties extends Properties {

	public ResourceProperties(final String resourceOnClasspath) throws IOException {
		super.load((new ResourceInputStream(resourceOnClasspath)));
	}
}
