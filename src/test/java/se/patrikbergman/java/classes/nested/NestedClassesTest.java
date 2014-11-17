package se.patrikbergman.java.classes.nested;

import org.junit.Test;
import se.patrikbergman.java.utility.JsonString;

import java.io.IOException;

import static se.patrikbergman.java.classes.nested.OuterClassForBandMembers.StaticBandMember;

public class NestedClassesTest {

	@Test
	public void testNestedClasses() throws IOException {
		OuterClassForBandMembers outerClassForBandMembers = new OuterClassForBandMembers();
		OuterClassForBandMembers.NestedBandMember nestedBandMember = outerClassForBandMembers. new NestedBandMember("William Goldsmith");
		StaticBandMember staticBandMember = new StaticBandMember("Dave Grohl");

		System.out.println(new JsonString(nestedBandMember));
		System.out.println(new JsonString(staticBandMember));

	}
}
