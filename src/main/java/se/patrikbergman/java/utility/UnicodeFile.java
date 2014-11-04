package se.patrikbergman.java.utility;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * http://www.javacodegeeks.com/2014/09/oop-alternative-to-utility-classes.html
 */
public class UnicodeFile {
	private final URI uri;
	private final Path path;
	private final Charset charset;

	public UnicodeFile(String resource, String charsetName) throws URISyntaxException, FileNotFoundException {
		this.uri = getUrl(resource).toURI();
		this.path = Paths.get(uri);
		this.charset = Charset.forName(charsetName);
	}

	public Path getPath() {
		return path;
	}

	public Charset getCharset() {
		return charset;
	}

	public URI getUri() {
		return uri;
	}

	private URL getUrl(String resource) throws FileNotFoundException {
		final URL url = UnicodeFile.class.getClassLoader().getResource(resource);
		if(url == null)
			throw new FileNotFoundException(String.format("Could not find resource %s", resource));
		return url;
	}

	@Override
	public String toString() {
		return "UnicodeFile{" +
				"uri=" + uri +
				", path=" + path +
				", charset=" + charset +
				'}';
	}
}
