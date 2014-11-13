package se.patrikbergman.java.classes.anonymous;

import org.junit.Test;
import se.patrikbergman.java.utility.JsonString;

import java.io.IOException;

public class AnonymousClassTest {

	@Test
	public void testAnonymousClasses() throws IOException {
		BlackSabbath blackSabbath = new BlackSabbath();
		System.out.println(new JsonString(blackSabbath));
	}
}
