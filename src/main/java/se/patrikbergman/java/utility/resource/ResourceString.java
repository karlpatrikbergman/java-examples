package se.patrikbergman.java.utility.resource;

import com.google.common.base.Preconditions;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class ResourceString {
	private static final String ENCODING = "UTF-8";
	private final String string;

	public ResourceString(final String resourceOnClasspath) throws IOException {
		Preconditions.checkNotNull(resourceOnClasspath);
		this.string = IOUtils.toString(new ResourceInputStream(resourceOnClasspath), ENCODING);
	}

	@Override
	public String toString() {
		return string.toString();
	}
}
