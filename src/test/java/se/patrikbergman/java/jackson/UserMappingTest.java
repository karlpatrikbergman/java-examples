package se.patrikbergman.java.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.collect.ImmutableList;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class UserMappingTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
		mapper.registerModule(new GuavaModule());
	}

	@Test
	public void serializeUser() throws JsonProcessingException {
		final ImmutableList<String> messages = ImmutableList.of("Message 1", "Message 2", "Message 3", "Message 4");
		final LocalDate localDate = LocalDate.now();
		final User user = new User(localDate, 99, "Patrik Bergman", messages);
		String jsonString = mapper.writeValueAsString(user);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //Unmarhsal/Deserialize
	public void unmarhallUser() throws IOException {
		final ResourceString userJsonResourceString = new ResourceString("jackson/user.json");
		final String userJsonString = userJsonResourceString.toString();
		final User user = mapper.readValue(userJsonString, User.class);
		System.out.println(user);
	}
}
