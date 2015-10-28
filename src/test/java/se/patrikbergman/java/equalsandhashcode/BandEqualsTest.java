package se.patrikbergman.java.equalsandhashcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static se.patrikbergman.java.equalsandhashcode.BandValueObjectFactory.createJudasPriestValueObject;
import static se.patrikbergman.java.equalsandhashcode.BandValueObjectFactory.createSaxonValueObject;

public class BandEqualsTest {

    private final Band judasPriestValueObjectX = createJudasPriestValueObject();
    private final Band judasPriestValueObjectY = createJudasPriestValueObject();
    private final Band judasPriestValueObjectZ = createJudasPriestValueObject();
    private final Band saxonValueObject = createSaxonValueObject();

    /**
     *  For any non-null reference value x,x.equals(x) must return true.
     */
    @Test
    public void reflexivity() {
        assertTrue(judasPriestValueObjectX.equals(judasPriestValueObjectX));
    }

    /**
     * For any non-null reference values x and y,x.equals(y) must re-turntrue if and only if y.equals(x)
     * returns true
     */
    @Test
    public void symmetry() {
        assertTrue(judasPriestValueObjectX.equals(judasPriestValueObjectY) &&
                judasPriestValueObjectX.equals(judasPriestValueObjectY));

    }

    /**
     *  For any non-null reference values x,y,z, if x.equals(y) returns true and y.equals(z)
     *  returns true, then x.equals(z) must return true
     */
    @Test
    public void transitivity() {
        assertTrue(
                judasPriestValueObjectX.equals(judasPriestValueObjectY) &&
                judasPriestValueObjectY.equals(judasPriestValueObjectZ) &&
                judasPriestValueObjectX.equals(judasPriestValueObjectZ)
        );
    }

    /**
     * For any non-null reference values x and y, multiple invocationsofx.equals(y) consistently
     * return true or consistently return false, pro-vided no information used in equals
     * comparisons on the objects is modified
     */
    @Test
    public void consistency() {
        assertTrue(
                judasPriestValueObjectX.equals(judasPriestValueObjectY) &&
                judasPriestValueObjectX.equals(judasPriestValueObjectY)
        );
    }

    @Test
    public void equalsToSaxonShouldReturnFalse() {
        assertFalse(judasPriestValueObjectX.equals(saxonValueObject));
        assertFalse(judasPriestValueObjectY.equals(saxonValueObject));
    }

    @Test
    public void equalsToSomeStringShouldReturnFalse() {
        assertFalse(judasPriestValueObjectX.equals("Some string"));
    }

    @Test
    public void equalsToNullShouldReturnFalse() {
        assertFalse(saxonValueObject.equals(null));
    }


}
