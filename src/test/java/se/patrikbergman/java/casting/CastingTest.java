package se.patrikbergman.java.casting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static se.patrikbergman.java.casting.AnimalUtil.getAnimalThatIsADog;

public class CastingTest {

    @Test
    public void upCast() {
        assertTrue(getAnimalThatIsADog() instanceof Dog);
    }

    @Test
    public void upCastAndSetBreed() {
        Dog dog = new Dog("Laban");
        assertNull(dog.getBreed());
        final String expectedBreed = "English Bulldog";
        AnimalUtil.upCastToDogAndSetBreed(dog, expectedBreed);
        assertEquals(expectedBreed, dog.getBreed());
    }
}
