package se.patrikbergman.java.classes.nested;

import org.junit.Test;
import se.patrikbergman.java.utility.JsonString;

import static org.junit.Assert.assertEquals;
import static se.patrikbergman.java.classes.nested.OuterClassForBandMembers.STATIC_TOUR_MEMORY;

public class NestedClassesTest {



	@Test
	public void testStaticNestedClassBandMember() {
		OuterClassForBandMembers.StaticNestedClassBandMember staticNestedClassBandMember = new OuterClassForBandMembers.StaticNestedClassBandMember("Dave Grohl");
		assertEquals(STATIC_TOUR_MEMORY, staticNestedClassBandMember.getTourMemory());
        System.out.println(new JsonString(staticNestedClassBandMember));
	}

    @Test
    public void testInnerClassBandMember() {
        final String instanceTourMemory = "Instance Tour Memory: I am We had great burgers in Stockholm in 2002";
        OuterClassForBandMembers outerClassForBandMembers = new OuterClassForBandMembers(instanceTourMemory);
        OuterClassForBandMembers.InnerClassBandMember innerClassBandMember = outerClassForBandMembers.new InnerClassBandMember("William Goldsmith");
        assertEquals(instanceTourMemory, innerClassBandMember.getTourMemory());
        System.out.println(new JsonString(innerClassBandMember));
    }
}
