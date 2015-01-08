package se.patrikbergman.java.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import se.patrikbergman.java.utility.resource.ResourceString;

public class MappingTest {
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			final ResourceString userJsonResourceString = new ResourceString("user.json");
			final String userJsonString = userJsonResourceString.toString();
			final User user = mapper.readValue(userJsonString, User.class);
			System.out.println(user);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
