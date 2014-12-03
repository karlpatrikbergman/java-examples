package se.patrikbergman.java.utility.resource;


import com.google.common.base.Preconditions;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class ResourceInputStream extends InputStream {

	private final InputStream inputStream;

	public ResourceInputStream(final String pathToResource) throws IOException {
		Preconditions.checkNotNull(pathToResource);
		this.inputStream = new ClassPathResource(pathToResource).getInputStream();
	}

	@Override
	public int read() throws IOException {
		return inputStream.read();
	}
}
