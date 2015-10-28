package se.patrikbergman.java.equalsandhashcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.patrikbergman.java.equalsandhashcode.BandValueObjectFactory.createJudasPriestValueObject;

public class BandHashCodeTest {

    private final Band judasPriestValueObjectX = createJudasPriestValueObject();
    private final Band judasPriestValueObjectY = createJudasPriestValueObject();

    @Test
    public void equalBandValueObjectsReturnsEqualHashCode() {
        assertEquals(judasPriestValueObjectX.hashCode(), judasPriestValueObjectY.hashCode());
    }
}
