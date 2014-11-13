package se.patrikbergman.java.utility.resource;

import com.google.common.base.Preconditions;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class InputStreamString {
	private static final String ENCODING = "UTF-8";
	private final String string;

	public InputStreamString(ResourceInputStream resourceInputStream) throws IOException {
		Preconditions.checkNotNull(resourceInputStream);
		this.string = IOUtils.toString(resourceInputStream.getInputStream(), ENCODING);
	}

	public String getString() {
		return string;
	}
}
