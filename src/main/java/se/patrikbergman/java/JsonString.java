package se.patrikbergman.java;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.util.DefaultPrettyPrinter;

import java.io.IOException;

public class JsonString {

	private final String jsonString;

	public JsonString(Object object) throws IOException {
		final DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
		prettyPrinter.indentArraysWith(new DefaultPrettyPrinter.Lf2SpacesIndenter());
		final ObjectMapper objectMapper = new ObjectMapper();
		this.jsonString = objectMapper.writer(prettyPrinter).writeValueAsString(object);
	}

	@Override
	public String toString() {
		return jsonString;
	}
}
