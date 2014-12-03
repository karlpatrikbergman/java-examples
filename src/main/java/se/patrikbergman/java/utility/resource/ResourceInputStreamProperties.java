package se.patrikbergman.java.utility.resource;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.util.Properties;

public class ResourceInputStreamProperties extends Properties {

	public ResourceInputStreamProperties(final ResourceInputStream resourceInputStream) throws IOException {
		Preconditions.checkNotNull(resourceInputStream);
		super.load(resourceInputStream);
	}
}
